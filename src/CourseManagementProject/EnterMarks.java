package CourseManagementProject;

//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

//Extending JFrame as Parent Class
public class EnterMarks extends JFrame implements ActionListener {

	// declaring varibales for GUI representation
	JLabel l1;
	JTable t1;
	JButton b1, b2;
	private JPanel panel;

	EnterMarks() {
		super("Marks details for the module");
		getContentPane().setBackground(new Color(235, 248, 164));

		String data[][] = new String[15][8];
		String column[] = { "Semester", "Modules", "ModuleID", "Student Name", "Student ID", "Marks" };
		int i = 0, j = 0;

		try {
			Connect c1 = new Connect();
			String s1 = "select * from result";
			ResultSet rs = c1.s.executeQuery(s1);
			while (rs.next()) {
				data[i][j++] = rs.getString("Semester");
				data[i][j++] = rs.getString("Modules");
				data[i][j++] = rs.getString("ModuleCode");
				data[i][j++] = rs.getString("Studentname");
				data[i][j++] = rs.getString("ID");
				data[i][j++] = String.valueOf(rs.getDouble("Marks"));
				i++;
				j = 0;
			}
			t1 = new JTable(data, column);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JScrollPane sp = new JScrollPane(t1);
		sp.setBounds(293, 133, 473, 282);
		getContentPane().add(sp);

		b1 = new JButton("Enter Marks Now");
		b1.setBounds(409, 460, 204, 30);
		b1.setFont(new Font("roboto", Font.BOLD, 15));
		b1.setFocusable(false);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.BLACK);
		b1.addActionListener(this);
		getContentPane().add(b1);

		b2 = new JButton("Back");
		b2.setBounds(637, 460, 129, 30);
		b2.setFont(new Font("roboto", Font.BOLD, 15));
		b2.setFocusable(false);
		b2.setBackground(Color.black);
		b2.setForeground(Color.BLACK);
		b2.addActionListener(this);
		getContentPane().add(b2);

		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(198, 136, 156));
		panel.setBounds(0, -15, 257, 707);
		getContentPane().add(panel);
		panel.setLayout(null);

		l1 = new JLabel("Marks Table");
		l1.setForeground(new Color(255, 255, 255));
		l1.setFont(new Font("Serif", Font.BOLD, 30));
		l1.setBounds(45, 294, 186, 30);
		panel.add(l1);
		setSize(810, 681);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1) {
			this.dispose();
			new InsertMarks();

		}

		if (e.getSource() == b2) {
			this.dispose();
		}

	}
}
