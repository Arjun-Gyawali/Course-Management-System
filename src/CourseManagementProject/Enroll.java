package CourseManagementProject;

//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

//Extending JFrame as Parent Class
public class Enroll extends JFrame implements ActionListener {

	// declaring variables for GUI representation
	private JLabel acrse, ecrse;
	private JTable ctable, crstable;
	public JButton erolnow, bck;
	public String column[] = { "Level", "Semester", "Modules", "ModuleCode" };
	public String data[][] = new String[50][6];
	public String row[][] = new String[50][5];
	private int i = 0, j = 0, x = 0, y = 0;
	String name;
	private JPanel panel;

	Enroll(String name) {

		super("Course Enrollment");
		getContentPane().setBackground(new Color(235, 248, 164));
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		erolnow = new JButton("Enroll now");
		erolnow.setBackground(Color.BLACK);
		erolnow.setForeground(Color.BLACK);
		erolnow.setBounds(610, 268, 125, 30);
		erolnow.setFocusable(false);
		getContentPane().add(erolnow);
		erolnow.addActionListener(this);

		bck = new JButton("Back");
		bck.setBackground(Color.BLACK);
		bck.setForeground(Color.BLACK);
		bck.setBounds(760, 268, 135, 30);
		bck.setFocusable(false);
		getContentPane().add(bck);
		bck.addActionListener(this);

//Upper Table
		try {
			Connect c1 = new Connect();
			String s1 = "select * from coursetable";
			ResultSet rs = c1.s.executeQuery(s1);
			while (rs.next()) {
				data[i][j++] = rs.getString("Level");
				data[i][j++] = rs.getString("Semester");
				data[i][j++] = rs.getString("Modules");
				data[i][j++] = rs.getString("ModuleCode");
				i++;
				j = 0;
			}
			ctable = new JTable(data, column);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JScrollPane sp = new JScrollPane(ctable);
		sp.setBounds(328, 38, 567, 180);
		getContentPane().add(sp);

		panel = new JPanel();
		panel.setBackground(new Color(198, 136, 156));
		panel.setBounds(-17, -28, 300, 691);
		getContentPane().add(panel);
		panel.setLayout(null);

		acrse = new JLabel("Available Course");
		acrse.setBounds(65, 135, 205, 40);
		panel.add(acrse);
		acrse.setForeground(new Color(255, 255, 255));
		acrse.setFont(new Font("roboto", Font.BOLD, 22));

		ecrse = new JLabel("Enrolled Course");
		ecrse.setBounds(68, 411, 174, 40);
		panel.add(ecrse);
		ecrse.setForeground(new Color(255, 255, 255));
		ecrse.setFont(new Font("roboto", Font.BOLD, 22));

		setSize(970, 655);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	@Override

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == bck) {
			this.dispose();
			new StudentPanel(this.name);
		}

		if (e.getSource() == erolnow) {
			try {
				Connect c2 = new Connect();
				String s2 = "select * from coursetable";
				ResultSet res = c2.s.executeQuery(s2);
				while (res.next()) {
					row[x][y++] = res.getString("Level");
					row[x][y++] = res.getString("Semester");
					row[x][y++] = res.getString("Modules");
					row[x][y++] = res.getString("ModuleCode");
					x++;
					y = 0;
				}
				crstable = new JTable(row, column);

			} catch (SQLException ae) {
				ae.printStackTrace();
			}

			JScrollPane sp1 = new JScrollPane(crstable);
			sp1.setBounds(328, 380, 600, 150);
			getContentPane().add(sp1);

		}

	}

}
