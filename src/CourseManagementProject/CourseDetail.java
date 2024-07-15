package CourseManagementProject;

//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

//Extending JFrame as Parent Class
public class CourseDetail extends JFrame implements ActionListener {

	// declaring varibales for GUI representation
	private JLabel crname, adcrse, upcrse;
	public JTable t1;
	public JButton del, adcrsemod, upcrsemod, cncl;
	public JTextField t2;
	public String column[] = { "Course", "Level", "Semester", "Modules", "ModuleCode", "TeacherName" };
	public String data[][] = new String[20][13];
	private int i = 0, j = 0;

	CourseDetail() {

		super("Module and Course Details");
		getContentPane().setLayout(null);

		crname = new JLabel("Enter the module to delete : ");
		crname.setBounds(348, 495, 243, 30);
		crname.setFont(new Font("Dialog", Font.BOLD, 15));
		getContentPane().add(crname);

		t2 = new JTextField();
		t2.setBounds(601, 496, 200, 34);
		getContentPane().add(t2);

		del = new JButton("Delete");
		del.setBackground(new Color(0, 0, 0));
		del.setForeground(Color.BLACK);
		del.setBounds(818, 497, 90, 30);
		getContentPane().add(del);

		adcrse = new JLabel("Add Course:");
		adcrse.setBounds(348, 386, 130, 30);
		adcrse.setFont(new Font("Dialog", Font.BOLD, 15));
		getContentPane().add(adcrse);

		adcrsemod = new JButton("Add Course and Module");
		adcrsemod.setBackground(Color.BLACK);
		adcrsemod.setForeground(Color.BLACK);
		adcrsemod.setBounds(601, 388, 200, 30);
		getContentPane().add(adcrsemod);

		upcrse = new JLabel("Update Course and Modules:");
		upcrse.setBounds(348, 439, 258, 30);
		upcrse.setFont(new Font("Dialog", Font.BOLD, 15));
		getContentPane().add(upcrse);

		upcrsemod = new JButton("Update Module and Course");
		upcrsemod.setBackground(Color.BLACK);
		upcrsemod.setForeground(Color.BLACK);
		upcrsemod.setBounds(601, 441, 200, 30);
		getContentPane().add(upcrsemod);

		cncl = new JButton("Cancel");
		cncl.setBackground(new Color(0, 0, 0));
		cncl.setForeground(Color.BLACK);
		cncl.setBounds(818, 441, 90, 30);
		getContentPane().add(cncl);

		del.addActionListener(this);
		adcrsemod.addActionListener(this);
		upcrsemod.addActionListener(this);
		cncl.addActionListener(this);

		try {
			Connect c1 = new Connect();
			String s1 = "select * from coursetable";
			ResultSet rs = c1.s.executeQuery(s1);
			while (rs.next()) {
				data[i][j++] = rs.getString("Course");
				data[i][j++] = rs.getString("Level");
				data[i][j++] = rs.getString("Semester");
				data[i][j++] = rs.getString("Modules");
				data[i][j++] = rs.getString("ModuleCode");
				data[i][j++] = rs.getString("TeacherName");
				i++;
				j = 0;
			}
			t1 = new JTable(data, column);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JScrollPane sp = new JScrollPane(t1);
		sp.setBounds(348, 100, 579, 263);
		getContentPane().add(sp);

		getContentPane().setBackground(new Color(235, 248, 164));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(198, 136, 156));
		panel.setBounds(-11, -18, 302, 736);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Module and Course Details");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(20, 294, 282, 79);
		panel.add(lblNewLabel);

		setSize(951, 738);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Connect c1 = null;
		try {
			c1 = new Connect();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		if (e.getSource() == del) {
			try {
				String a = t2.getText();
				String q = "delete from coursetable where Modules = '" + a + "'";
				c1.s.executeUpdate(q);
				this.dispose();
				new CourseDetail().setVisible(true);
			} catch (Exception ex) {
				ex.printStackTrace();

			}

		} else if (e.getSource() == adcrsemod) {
			this.dispose();
			new AddCourse().setVisible(true);
		} else if (e.getSource() == upcrsemod) {
			this.dispose();
			new EditCourse().setVisible(true);
		} else if (e.getSource() == cncl) {
			this.dispose();
			new AdminPanel().setVisible(true);
		}
	}
}
