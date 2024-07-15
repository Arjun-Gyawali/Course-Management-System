package CourseManagementProject;

//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

//Extending JFrame as Parent Class
public class EditCourse extends JFrame implements ActionListener {

	// declaring varibales for GUI representation
	private JLabel l1, l3, l4, l5, l6, l7, l8;
	private JTextField t1, t2, t3, t4, t5, t6, t7;
	public JButton b1, b2, b3;
	private JLabel lblNewLabel;

	EditCourse() {

		super("Edit Course and Module");
		getContentPane().setBackground(new Color(235, 248, 164));
		getContentPane().setLayout(null);

		l1 = new JLabel(" Module Name");
		l1.setForeground(new Color(0, 0, 0));
		l1.setBounds(346, 75, 135, 30);
		l1.setFont(new Font("Dialog", Font.PLAIN, 20));
		getContentPane().add(l1);

		t1 = new JTextField();
		t1.setBounds(531, 75, 150, 30);
		getContentPane().add(t1);

		b1 = new JButton("Enter");
		b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b1.setBackground(new Color(255, 255, 255));
		b1.setForeground(new Color(0, 0, 0));
		b1.setBounds(703, 75, 115, 30);
		getContentPane().add(b1);
		b1.addActionListener(this);

		l3 = new JLabel("Course Name");
		l3.setBounds(346, 151, 150, 30);
		l3.setFont(new Font("Dialog", Font.PLAIN, 15));
		getContentPane().add(l3);

		t2 = new JTextField();
		t2.setBounds(531, 154, 150, 30);
		getContentPane().add(t2);

		l4 = new JLabel("Module Name");
		l4.setBounds(346, 307, 135, 30);
		l4.setFont(new Font("Dialog", Font.PLAIN, 15));
		getContentPane().add(l4);

		t3 = new JTextField();
		t3.setBounds(531, 368, 150, 30);
		getContentPane().add(t3);

		l5 = new JLabel("Module ID");
		l5.setBounds(346, 200, 135, 30);
		l5.setFont(new Font("Dialog", Font.PLAIN, 15));
		getContentPane().add(l5);

		t4 = new JTextField();
		t4.setBounds(531, 203, 150, 30);
		getContentPane().add(t4);

		l6 = new JLabel("Year");
		l6.setBounds(346, 365, 135, 30);
		l6.setFont(new Font("Dialog", Font.PLAIN, 15));
		getContentPane().add(l6);

		t5 = new JTextField();
		t5.setBounds(531, 310, 150, 30);
		getContentPane().add(t5);

		l7 = new JLabel("Semester");
		l7.setBounds(346, 253, 100, 30);
		l7.setFont(new Font("Dialog", Font.PLAIN, 15));
		getContentPane().add(l7);

		t6 = new JTextField();
		t6.setBounds(531, 253, 150, 30);
		getContentPane().add(t6);

		l8 = new JLabel("Tutor");
		l8.setBounds(346, 422, 84, 30);
		l8.setFont(new Font("Dialog", Font.PLAIN, 15));
		getContentPane().add(l8);

		t7 = new JTextField();
		t7.setBounds(531, 422, 150, 30);
		getContentPane().add(t7);

		b2 = new JButton("Submit");
		b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b2.setBackground(new Color(255, 255, 255));
		b2.setForeground(new Color(0, 0, 0));
		b2.setBounds(566, 502, 115, 30);
		getContentPane().add(b2);
		b2.addActionListener(this);

		b3 = new JButton("Back");
		b3.setBounds(703, 502, 115, 30);
		b3.setFont(new Font("roboto", Font.BOLD, 15));
		b3.addActionListener(this);
		b3.setBackground(new Color(0, 0, 0));
		b3.setForeground(Color.BLACK);
		getContentPane().add(b3);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(198, 136, 156));
		panel.setBounds(0, 0, 281, 613);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("Edit Course");
		lblNewLabel.setBounds(51, 263, 181, 32);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);

		setSize(842, 618);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b2) {
			try {
				Connect c = new Connect();
				String str = "Update coursetable set Course='" + t2.getText() + "',Level='" + t3.getText()
						+ "',Semester='" + t4.getText() + "', Modules='" + t5.getText() + "',ModuleCode='"
						+ t6.getText() + "',Teachername='" + t7.getText() + "' where Modules= '" + t1.getText() + "'";
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Course and Modules successfully updated");
				setVisible(false);
				new AddCourse();
			} catch (Exception ex) {
				System.out.println("The error is:" + ex);
			}
		}
		if (e.getSource() == b3) {
			setVisible(false);
			new AdminPanel().setVisible(true);
		}
		if (e.getSource() == b1) {
			try {
				Connect c = new Connect();
				String str = "select * from coursetable where Modules = '" + t1.getText() + "'";
				ResultSet rs = c.s.executeQuery(str);
				while (rs.next()) {
					t2.setText(rs.getString("Course"));
					t3.setText(rs.getString("Level"));
					t4.setText(rs.getString("Semester"));
					t5.setText(rs.getString("Modules"));
					t6.setText(rs.getString("ModuleCode"));
					t7.setText(rs.getString("Teachername"));

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
