package CourseManagementProject;

//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Extending JFrame as Parent Class
public class AddTeacher extends JFrame implements ActionListener {

	// declaring variables for GUI representation
	private JLabel name, email, username, id, password, Course, urole;
	private JTextField Tname, eml, uname, Id;
	private JPasswordField pass;
	private JComboBox crs, Role;
	private JButton submit, cncl;

	private String role[] = { "Faculty" };
	private JLabel lblAddTeacher;

	public AddTeacher() {

		super("Add Teacher");
		getContentPane().setFont(new Font("Dialog", Font.PLAIN, 15));
		setBackground(Color.white);
		getContentPane().setLayout(null);

		name = new JLabel("Name");
		name.setFont(new Font("Dialog", Font.PLAIN, 15));
		name.setBounds(404, 67, 100, 30);
		getContentPane().add(name);
		Tname = new JTextField();
		Tname.setBounds(514, 67, 150, 30);
		getContentPane().add(Tname);

		email = new JLabel("Email");
		email.setFont(new Font("Dialog", Font.PLAIN, 15));
		email.setBounds(404, 284, 83, 30);
		getContentPane().add(email);
		eml = new JTextField();
		eml.setBounds(514, 279, 150, 30);
		getContentPane().add(eml);

		username = new JLabel("Username");
		username.setFont(new Font("Dialog", Font.PLAIN, 15));
		username.setBounds(404, 117, 100, 30);
		getContentPane().add(username);
		uname = new JTextField();
		uname.setBounds(514, 117, 150, 30);
		getContentPane().add(uname);

		id = new JLabel("ID");
		id.setFont(new Font("Dialog", Font.PLAIN, 15));
		id.setBounds(404, 378, 100, 30);
		getContentPane().add(id);
		Id = new JTextField();
		Id.setBounds(514, 379, 150, 30);
		getContentPane().add(Id);

		password = new JLabel("Password");
		password.setFont(new Font("Dialog", Font.PLAIN, 15));
		password.setBounds(404, 328, 100, 30);
		getContentPane().add(password);
		pass = new JPasswordField();
		pass.setBounds(514, 329, 150, 30);
		getContentPane().add(pass);

		urole = new JLabel("User Role");
		urole.setFont(new Font("Dialog", Font.PLAIN, 15));
		urole.setBounds(404, 229, 150, 30);
		getContentPane().add(urole);
		Role = new JComboBox(role);
		Role.setBounds(514, 229, 150, 30);
		getContentPane().add(Role);

		Course = new JLabel("Course");
		Course.setFont(new Font("Dialog", Font.PLAIN, 15));
		Course.setBounds(404, 167, 100, 30);
		getContentPane().add(Course);
		String aray[] = null;
		try {
			Connect c = new Connect();
			String a = "Select Course from courseTable";
			ResultSet rs = c.s.executeQuery(a);
			ArrayList<String> list = new ArrayList<>();
			int x = 0;
			while (rs.next()) {

				if (!list.contains(rs.getString("Course"))) {
					list.add(rs.getString("Course"));

				}

			}
			aray = (String[]) list.toArray(new String[list.size()]);
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		crs = new JComboBox(aray);
		crs.setBounds(514, 167, 150, 30);
		getContentPane().add(crs);

		submit = new JButton("Add");
		submit.setBounds(404, 450, 120, 30);
		submit.setFont(new Font("roboto", Font.BOLD, 15));
		submit.addActionListener(this);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.BLACK);
		getContentPane().add(submit);

		cncl = new JButton("back");
		cncl.setBounds(554, 450, 120, 30);
		cncl.setFont(new Font("roboto", Font.BOLD, 15));
		cncl.addActionListener(this);
		cncl.setBackground(new Color(0, 0, 0));
		cncl.setForeground(Color.BLACK);
		getContentPane().add(cncl);

		getContentPane().setBackground(new Color(235, 248, 164));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(198, 136, 156));
		panel.setBounds(0, 0, 330, 586);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblAddTeacher = new JLabel("Add Tutor or Lecturer");
		lblAddTeacher.setBounds(10, 244, 310, 33);
		panel.add(lblAddTeacher);
		lblAddTeacher.setForeground(Color.WHITE);
		lblAddTeacher.setFont(new Font("Algerian", Font.PLAIN, 25));

		setVisible(true);
		setSize(747, 623);
		setLocation(400, 200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String namee = Tname.getText();
		String emaill = eml.getText();
		String unamee = uname.getText();
		String passs = pass.getText();
		String ID = Id.getText();
		String course = (String) crs.getSelectedItem();
		String role = (String) Role.getSelectedItem();
		if (e.getSource() == submit) {
			try {
				Connect c1 = new Connect();
				String a = "Insert into teacherlogin(name,email,username,pass,role,ID,course)  values('" + namee + "','"
						+ emaill + "','" + unamee + "','" + passs + "','" + role + "','" + ID + "','" + course + "')";
				c1.s.executeUpdate(a);

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

			JOptionPane.showMessageDialog(null, "User Created Successfully");
			setVisible(false);
			new AdminPanel().setVisible(true);

		}
		if (e.getSource() == cncl) {
			this.dispose();
			new AdminPanel().setVisible(true);
		}

	}
}
