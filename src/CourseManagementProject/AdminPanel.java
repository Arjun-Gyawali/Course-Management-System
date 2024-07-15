package CourseManagementProject;
//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Extending JFrame as Parent Class
public class AdminPanel extends JFrame implements ActionListener {

	AdminPanel() {
		super("School Management System");
		setLocation(0, -78);
		getContentPane().setBackground(new Color(235, 248, 164));
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(198, 136, 156));
		panel.setBounds(0, -74, 225, 597);
		getContentPane().add(panel);
		panel.setLayout(null);

		JMenu user = new JMenu("Details");
		user.setBounds(0, 119, 150, 39);
		panel.add(user);
		JMenuItem u1 = new JMenuItem("Student Details");
		JMenuItem u2 = new JMenuItem("Teacher Details");
		user.setForeground(new Color(0, 0, 0));
		user.setFont(new Font("Poppins", Font.PLAIN, 27));

		u1.setFont(new Font("monospaced", Font.BOLD, 16));
		u1.setBackground(Color.WHITE);

		u2.setFont(new Font("monospaced", Font.BOLD, 16));
		u2.setBackground(Color.WHITE);

		u1.addActionListener(this);
		u2.addActionListener(this);

		user.add(u1);
		user.add(u2);

		JMenu crse = new JMenu("View Course");
		crse.setBounds(0, 218, 215, 39);
		panel.add(crse);
		JMenuItem r1 = new JMenuItem("View Module and Course");
		crse.setForeground(new Color(0, 0, 0));
		crse.setFont(new Font("Poppins", Font.PLAIN, 27));

		r1.setFont(new Font("monospaced", Font.BOLD, 16));
		r1.setBackground(Color.WHITE);

		r1.addActionListener(this);

		crse.add(r1);

		JMenu res = new JMenu("Result");
		res.setBounds(0, 321, 127, 39);
		panel.add(res);
		JMenuItem c2 = new JMenuItem("Generate Report");
		res.setForeground(new Color(0, 0, 0));
		res.setFont(new Font("Poppins", Font.PLAIN, 27));

		c2.setFont(new Font("monospaced", Font.BOLD, 16));

		c2.setBackground(Color.WHITE);
		res.add(c2);

		JMenu exit = new JMenu("Want to Exit?");
		exit.setBounds(0, 472, 220, 39);
		panel.add(exit);
		JMenuItem ex = new JMenuItem("Exit");
		exit.setForeground(new Color(0, 0, 0));
		exit.setFont(new Font("Poppins", Font.PLAIN, 27));

		ex.setFont(new Font("monospaced", Font.BOLD, 16));

		ex.setBackground(Color.WHITE);

		ex.addActionListener(this);

		exit.add(ex);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Arjun\\Desktop\\admin.png"));
		lblNewLabel_1.setBounds(404, 85, 346, 332);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Hello Admin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(388, 48, 330, 27);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Arjun\\Desktop\\cmsIcons\\admin.png"));
		lblNewLabel_2.setBounds(388, 133, 330, 284);
		getContentPane().add(lblNewLabel_2);
		c2.addActionListener(this);

		setSize(887, 601);
		setLocationRelativeTo(null);

		JMenuBar mb = new JMenuBar();
		mb.setForeground(new Color(0, 0, 0));
		mb.setMargin(new Insets(5, 5, 5, 5));
		mb.setBackground(new Color(151, 193, 169));

		setJMenuBar(mb);
		JMenu New = new JMenu("New");
		mb.add(New);
		New.setBackground(new Color(0, 0, 0));
		JMenuItem m1 = new JMenuItem("New Teacher");
		JMenuItem m2 = new JMenuItem("New Student Admission");
		New.setForeground(new Color(0, 0, 0));
		New.setFont(new Font("Poppins", Font.PLAIN, 27));
		m1.addActionListener(this);
		m2.addActionListener(this);

		New.add(m1);
		New.add(m2);

		setFont(new Font("Senserif", Font.BOLD, 16));

		setVisible(false);
	}

	public void actionPerformed(ActionEvent ae) {
		String msg = ae.getActionCommand();
		if (msg.equals("New Student Admission")) {
			this.dispose();
			new AddStudent().setVisible(true);

		} else if (msg.equals("New Teacher")) {
			this.dispose();
			new AddTeacher().setVisible(true);

		} else if (msg.equals("Student Details")) {
			this.dispose();
			new StudentDetails().setVisible(true);

		} else if (msg.equals("Teacher Details")) {
			this.dispose();
			new TeacherDetails().setVisible(true);

		} else if (msg.equals("Generate Report")) {
			this.dispose();
			new SeeResult().setVisible(true);

		} else if (msg.equals("View Module and Course")) {
			this.dispose();
			new CourseDetail().setVisible(true);

		} else if (msg.equals("Exit")) {
			this.dispose();
			new Login();
		}

	}

	public static void main(String[] args) {
		new AdminPanel();
	}
}
