package CourseManagementProject;

//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

//Extending JFrame as Parent Class
public class StudentPanel extends JFrame implements ActionListener {

	// declaring variables for GUI representation
	JLabel nam;
	JButton vwmod, vwres, eroll, ext;
	String name;
	private JLabel lblNewLabel_1;
	private JPanel panel_2;

	StudentPanel(String name)

	{
		super("Student Panel");
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		this.name = name;

		String str = "Select * from studentlogin where name= '" + this.name + "'";
		try {
			Connect connect = new Connect();

			ResultSet rs = connect.s.executeQuery(str);
			if (rs.next()) {
				nam = new JLabel(rs.getString("name"));
				nam.setBounds(420, 100, 250, 50);
				nam.setFont(new Font("roboto", Font.BOLD, 20));
				nam.setForeground(Color.gray);
				getContentPane().add(nam);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		getContentPane().setBackground(new Color(235, 248, 164));

		lblNewLabel_1 = new JLabel("Student Name-");
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(263, 111, 145, 22);
		getContentPane().add(lblNewLabel_1);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(198, 136, 156));
		panel_2.setBounds(-17, -30, 270, 511);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		ext = new JButton("Exit");
		ext.setBounds(29, 332, 200, 40);
		panel_2.add(ext);
		ext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ext.setFocusable(false);

		vwres = new JButton("View Result");
		vwres.setBounds(29, 148, 200, 40);
		panel_2.add(vwres);
		vwres.setFont(new Font("Tahoma", Font.PLAIN, 15));
		vwres.setFocusable(false);

		eroll = new JButton("Enroll");
		eroll.setBounds(29, 233, 200, 40);
		panel_2.add(eroll);
		eroll.setFont(new Font("Tahoma", Font.PLAIN, 15));
		eroll.setFocusable(false);

		vwmod = new JButton("View Modules");
		vwmod.setBounds(29, 77, 200, 40);
		panel_2.add(vwmod);

		vwmod.setFont(new Font("Tahoma", Font.PLAIN, 15));
		vwmod.setFocusable(false);
		vwmod.addActionListener(this::actionPerformed);
		eroll.addActionListener(this);
		vwres.addActionListener(this);
		ext.addActionListener(this);

		setVisible(true);
		setSize(834, 449);
		setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vwmod) {
			this.dispose();
			new Module(this.name).setVisible(true);

		}

		if (e.getSource() == vwres) {
			this.dispose();
			new ViewResult(name).setVisible(true);

		}
		if (e.getSource() == eroll) {
			this.dispose();
			new Enroll(name).setVisible(true);

		}
		if (e.getSource() == ext) {
			this.dispose();
			new Login().setVisible(true);
		}

	}
}
