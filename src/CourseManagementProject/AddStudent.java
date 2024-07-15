package CourseManagementProject;

//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import com.jgoodies.forms.factories.DefaultComponentFactory;

//Extending JFrame as Parent Class
public class AddStudent extends JFrame implements ActionListener {
	// declaring varibales for GUI representation
	private JLabel name, Email, username, id, password, course, useroll;
	private JTextField sname, email, uname, Id;
	private JPasswordField pass;
	private JComboBox crse, userrole;
	private JButton submit, back;

	private String role[] = { "Student" };
	private JLabel lblNewLabel;

	public AddStudent() {

		super("Add Student");
		setBackground(Color.white);
		getContentPane().setLayout(null);

		name = new JLabel("Name");
		name.setFont(new Font("Dialog", Font.PLAIN, 15));
		name.setBounds(425, 70, 100, 30);
		getContentPane().add(name);
		sname = new JTextField();
		sname.setBounds(535, 70, 150, 30);
		getContentPane().add(sname);

		Email = new JLabel("Email");
		Email.setFont(new Font("Dialog", Font.PLAIN, 15));
		Email.setBounds(425, 220, 100, 30);
		getContentPane().add(Email);
		email = new JTextField();
		email.setBounds(535, 221, 150, 30);
		getContentPane().add(email);

		username = new JLabel("Username");
		username.setFont(new Font("Dialog", Font.PLAIN, 15));
		username.setBounds(425, 120, 100, 30);
		getContentPane().add(username);
		uname = new JTextField();
		uname.setBounds(535, 120, 150, 30);
		getContentPane().add(uname);

		id = new JLabel("ID");
		id.setFont(new Font("Dialog", Font.PLAIN, 15));
		id.setBounds(425, 323, 100, 30);
		getContentPane().add(id);
		Id = new JTextField();
		Id.setBounds(535, 324, 150, 30);
		getContentPane().add(Id);

		password = new JLabel("Password");
		password.setFont(new Font("Dialog", Font.PLAIN, 15));
		password.setBounds(425, 169, 100, 30);
		getContentPane().add(password);
		pass = new JPasswordField();
		pass.setBounds(535, 170, 150, 30);
		getContentPane().add(pass);

		course = new JLabel("Course");
		course.setFont(new Font("Dialog", Font.PLAIN, 15));
		course.setBounds(425, 274, 100, 30);
		getContentPane().add(course);
		String aray[] = null;
		try {
			Connect c = new Connect();
			String a = "Select Course from coursetable";
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
		crse = new JComboBox(aray);
		crse.setBounds(535, 274, 150, 30);
		getContentPane().add(crse);

		useroll = new JLabel("User Role");
		useroll.setFont(new Font("Dialog", Font.PLAIN, 15));
		useroll.setBounds(425, 373, 100, 30);
		getContentPane().add(useroll);
		userrole = new JComboBox(role);
		userrole.setBounds(535, 373, 150, 30);
		getContentPane().add(userrole);

		submit = new JButton("Add");
		submit.setBounds(426, 441, 120, 30);
		submit.setFont(new Font("roboto", Font.BOLD, 15));
		submit.addActionListener(this);
		submit.setBackground(new Color(0, 0, 0));
		submit.setForeground(Color.BLACK);
		getContentPane().add(submit);

		back = new JButton("back");
		back.setBounds(565, 441, 120, 30);
		back.setFont(new Font("roboto", Font.BOLD, 15));
		back.addActionListener(this);
		back.setBackground(new Color(0, 0, 0));
		back.setForeground(Color.BLACK);
		getContentPane().add(back);

		getContentPane().setBackground(new Color(235, 248, 164));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(198, 136, 156));
		panel.setBounds(0, 0, 312, 498);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("Add Student");
		lblNewLabel.setBounds(62, 220, 204, 40);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 30));

		setVisible(true);
		setSize(777, 545);
		setLocation(400, 200);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			try {
				Connect c1 = new Connect();
				String naame = sname.getText();
				String emaill = email.getText();
				String unamee = uname.getText();
				String passs = pass.getText();
				String idd = Id.getText();
				String course = (String) crse.getSelectedItem();
				String rol = (String) userrole.getSelectedItem();

				String a = "Insert into studentlogin(name,email,username,pass,role,ID,course)  values('" + naame + "','"
						+ emaill + "','" + unamee + "','" + passs + "','" + rol + "','" + idd + "','" + course + "')";
				c1.s.executeUpdate(a);

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "User Created Successfully");
			this.dispose();
			new AdminPanel().setVisible(true);

		}
		if (e.getSource() == back) {
			this.dispose();
			new AdminPanel().setVisible(true);
		}

	}
}
