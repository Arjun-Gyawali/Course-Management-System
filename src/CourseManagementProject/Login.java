package CourseManagementProject;

//importing all necessary libraries
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;

import java.awt.event.*;
import java.sql.*;

//Extending JFrame as Parent Class
public class Login extends JFrame implements ActionListener {

	private JLabel username, password, userrole;
	private JTextField name;
	private JPasswordField pass;
	private JComboBox cb;
	private JButton login;

	String role[] = { "Please Choose a Role", "Admin", "Faculty", "Student" };
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

//constructor
	Login() {

		super("Login");

		setBackground(Color.lightGray);
		getContentPane().setLayout(null);

		getContentPane().setBackground(new Color(235, 248, 164));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(198, 136, 156));
		panel.setBounds(-12, 0, 341, 627);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(22, 206, 309, 44);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 25));

		login = new JButton("Log In");
		login.setBounds(586, 332, 236, 40);
		getContentPane().add(login);
		login.setFont(new Font("Roboto", Font.BOLD, 15));
		login.addActionListener(this);
		login.setBackground(new Color(0, 0, 0));
		login.setForeground(new Color(0, 0, 0));

		userrole = new JLabel("User Role");
		userrole.setBounds(490, 258, 92, 30);
		getContentPane().add(userrole);
		userrole.setFont(new Font("Dialog", Font.PLAIN, 20));

		cb = new JComboBox(role);
		cb.setBounds(615, 258, 184, 34);
		getContentPane().add(cb);
		cb.setModel(new DefaultComboBoxModel(new String[] { " Choose a Role", "Admin", "Faculty", "Student" }));

		pass = new JPasswordField();
		pass.setBounds(615, 207, 184, 30);
		getContentPane().add(pass);

		name = new JTextField();
		name.setBounds(615, 158, 184, 30);
		getContentPane().add(name);

		username = new JLabel("Username");
		username.setBounds(490, 148, 111, 40);
		getContentPane().add(username);
		username.setFont(new Font("Dialog", Font.PLAIN, 20));

		password = new JLabel("Password");
		password.setBounds(490, 197, 111, 40);
		getContentPane().add(password);
		password.setFont(new Font("Dialog", Font.PLAIN, 20));

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(326, 35, 592, 448);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Arjun\\Desktop\\cmsIcons\\R3.png"));

		setVisible(true);
		setSize(932, 552);
		setLocation(500, 300);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == login) {
			try {
				Connect c1 = new Connect();
				String u = name.getText();
				String v = pass.getText();

				String q = "select * from admin where Uname='" + u + "' and pass='" + v + "'and Role = '"
						+ cb.getSelectedItem() + "'";
				String s = "select * from teacherlogin where username='" + u + "' and pass= '" + v + "' and Role='"
						+ cb.getSelectedItem() + "'";
				String t = "select * from studentlogin where username='" + u + "' and pass= '" + v + "' and Role='"
						+ cb.getSelectedItem() + "'";

				ResultSet rs = c1.s.executeQuery(q);
				if (rs.next()) {

					if (rs.getString("Role").equals("Admin")) {
						this.dispose();
						new AdminPanel().setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "Invalid login");
						setVisible(false);
					}
				}

				ResultSet res = c1.s.executeQuery(s);
				if (res.next()) {

					if (res.getString("Role").equals("Faculty")) {
						this.dispose();
						new TeacherPanel(res.getString("name")).setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "Invalid login");
						setVisible(false);
					}
				}
				ResultSet r = c1.s.executeQuery(t);
				if (r.next()) {

					if (r.getString("Role").equals("Student")) {
						this.dispose();
						new StudentPanel(r.getString("name")).setVisible(true);

					}

					else {
						JOptionPane.showMessageDialog(null, "Invalid login");
						setVisible(false);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] arg) {
		Login l = new Login();
	}
}
