package CourseManagementProject;

//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

//Extending JFrame as Parent Class
public class TeacherPanel extends JFrame implements ActionListener {
	// declaring varibales for GUI representation
	JLabel nm;
	JButton vm, etres, exit;
	String name;
	private JPanel panel_1;

	TeacherPanel(String name) {
		super("Teacher Panel");
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		this.name = name;

		String str = "Select * from teacherlogin where name= '" + this.name + "'";
		try {
			Connect connect = new Connect();

			ResultSet rs = connect.s.executeQuery(str);
			if (rs.next()) {
				nm = new JLabel(rs.getString("name"));
				nm.setBounds(100, 100, 250, 50);
				nm.setFont(new Font("roboto", Font.BOLD, 25));
				nm.setForeground(Color.black);
				getContentPane().add(nm);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		getContentPane().setBackground(new Color(235, 248, 164));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(198, 136, 156));
		panel_1.setBounds(531, 0, 255, 413);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		etres = new JButton("Enter Result");
		etres.setBounds(33, 49, 167, 40);
		panel_1.add(etres);
		etres.setFont(new Font("Dialog", Font.PLAIN, 15));
		etres.setFocusable(false);

		vm = new JButton("View Modules");
		vm.setBounds(34, 125, 167, 40);
		panel_1.add(vm);
		vm.setFont(new Font("Dialog", Font.PLAIN, 15));
		vm.setFocusable(false);

		exit = new JButton("Exit");
		exit.setBounds(39, 330, 161, 40);
		panel_1.add(exit);
		exit.setFont(new Font("Dialog", Font.PLAIN, 15));
		exit.setFocusable(false);
		exit.addActionListener(this);
		vm.addActionListener(this);
		etres.addActionListener(this);

		setVisible(true);
		setSize(800, 450);
		setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vm) {
			new ViewModule(name).setVisible(true);
		}

		if (e.getSource() == etres) {
			new EnterMarks().setVisible(true);
		}

		if (e.getSource() == exit) {
			this.dispose();
			new Login().setVisible(true);
		}

	}
}
