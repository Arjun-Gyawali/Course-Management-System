package CourseManagementProject;

//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

//Extending JFrame as Parent Class
public class StudentDetails extends JFrame implements ActionListener {

	// declaring variables for GUI representation
	private JLabel delstu, adnewstu;
	public JTable t1;
	public JButton del, adstu, bck;
	public JTextField id;
	public String column[] = { "Name", "Email", "Username", "Password", "ID", "Course" };
	public String data[][] = new String[20][13];
	private int i = 0, j = 0;
	private JPanel panel_1;
	private JLabel lblNewLabel;

	public StudentDetails() {
		super("Student Details");
		setSize(975, 708);
		setLocation(200, 200);
		getContentPane().setLayout(null);

		delstu = new JLabel("Enter Student ID to delete ");
		delstu.setBounds(311, 457, 179, 30);
		delstu.setFont(new Font("Dialog", Font.PLAIN, 15));
		getContentPane().add(delstu);

		id = new JTextField();
		id.setBounds(546, 460, 200, 30);
		getContentPane().add(id);

		del = new JButton("Delete");
		del.setBackground(new Color(0, 0, 0));
		del.setForeground(Color.BLACK);
		del.setBounds(851, 459, 100, 30);
		getContentPane().add(del);

		adnewstu = new JLabel("Add New Student:");
		adnewstu.setBounds(311, 52, 163, 30);
		adnewstu.setFont(new Font("Dialog", Font.PLAIN, 15));
		getContentPane().add(adnewstu);

		adstu = new JButton("Add Student");
		adstu.setBackground(Color.BLACK);
		adstu.setForeground(Color.BLACK);
		adstu.setBounds(836, 54, 115, 30);
		getContentPane().add(adstu);

		del.addActionListener(this);
		adstu.addActionListener(this);

		try {
			Connect c1 = new Connect();
			String s1 = "select * from studentlogin";
			ResultSet rs = c1.s.executeQuery(s1);
			while (rs.next()) {
				data[i][j++] = rs.getString("name");
				data[i][j++] = rs.getString("email");
				data[i][j++] = rs.getString("username");
				data[i][j++] = rs.getString("pass");
				data[i][j++] = rs.getString("ID");
				data[i][j++] = rs.getString("course");
				i++;
				j = 0;
			}
			t1 = new JTable(data, column);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JScrollPane sp = new JScrollPane(t1);
		sp.setBounds(311, 113, 640, 298);
		getContentPane().add(sp);

		getContentPane().setBackground(new Color(235, 248, 164));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(198, 136, 156));
		panel_1.setBounds(-29, -16, 326, 770);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel = new JLabel("Student Details");
		lblNewLabel.setBounds(41, 291, 275, 33);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel);

		bck = new JButton("Back");
		bck.setFocusable(false);
		bck.setBounds(851, 572, 100, 34);
		bck.setFont(new Font("roboto", Font.BOLD, 15));
		bck.setBackground(Color.BLACK);
		bck.setForeground(Color.BLACK);
		bck.addActionListener(this::actionPerformed);
		getContentPane().add(bck);

		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		del.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {

		Connect c1 = null;
		try {
			c1 = new Connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (ae.getSource() == del) {

			try {

				String a = id.getText();
				String q = "delete from studentlogin where ID = '" + a + "'";
				c1.s.executeUpdate(q);

			} catch (Exception e) {
				e.printStackTrace();
			}
			this.dispose();
			new StudentDetails().setVisible(true);
		}
		if (ae.getSource() == bck) {
			this.dispose();
			new AdminPanel().setVisible(true);
		}

		else if (ae.getSource() == adstu) {
			this.dispose();
			new AddStudent().setVisible(true);
		}

	}

	public static void main(String[] args) {
		new StudentDetails().setVisible(true);
	}
}
