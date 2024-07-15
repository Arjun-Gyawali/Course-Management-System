package CourseManagementProject;

//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
//import com.jgoodies.forms.factories.DefaultComponentFactory;

//Extending JFrame as Parent Class
public class AddCourse extends JFrame implements ActionListener {

	// declaring varibales for GUI representation
	private JLabel coursename, modulename, moduleid, title, level, semes, tutorname;
	private JTextField crsename;
	private JComboBox yearA;
	private JComboBox sem;
	private JTextField cb;
	protected JTextField modname;
	protected JTextField modid;
	protected JButton add, back, edit;
	public String crname, monam, moid, yra, yrb, cbx;
	public String year[] = { "Please Choose a year", "Level 3", "Level 4", "Level 5", "Level 6" };
	public String semester[] = { "Please Choose a semester", "1", "2", "3", "4", "5", "6", "7", "8" };

	public AddCourse() {
		super("Add Course");
		getContentPane().setBackground(new Color(235, 248, 164));

		getContentPane().setLayout(null);

		coursename = new JLabel("Course Name");
		coursename.setFont(new Font("Dialog", Font.PLAIN, 15));
		coursename.setBounds(407, 75, 120, 40);
		getContentPane().add(coursename);

		crsename = new JTextField();
		crsename.setBounds(558, 78, 175, 40);
		getContentPane().add(crsename);

		modulename = new JLabel("Module Name");
		modulename.setFont(new Font("Dialog", Font.PLAIN, 15));
		modulename.setBounds(407, 143, 120, 40);
		getContentPane().add(modulename);

		modname = new JTextField();
		modname.setBounds(558, 146, 175, 40);
		getContentPane().add(modname);

		moduleid = new JLabel("Module ID");
		moduleid.setFont(new Font("Dialog", Font.PLAIN, 15));
		moduleid.setBounds(407, 224, 120, 40);
		getContentPane().add(moduleid);

		modid = new JTextField();
		modid.setBounds(558, 224, 175, 40);
		getContentPane().add(modid);

		level = new JLabel("Year");
		level.setFont(new Font("Dialog", Font.PLAIN, 15));
		level.setBounds(407, 425, 80, 40);
		getContentPane().add(level);

		yearA = new JComboBox(year);
		yearA.setBounds(558, 427, 175, 40);
		getContentPane().add(yearA);

		semes = new JLabel("Semester");
		semes.setFont(new Font("Dialog", Font.PLAIN, 15));
		semes.setBounds(407, 296, 120, 40);
		getContentPane().add(semes);

		sem = new JComboBox(semester);
		sem.setBounds(558, 298, 175, 40);
		getContentPane().add(sem);

		tutorname = new JLabel("Tutor Name");
		tutorname.setFont(new Font("Dialog", Font.PLAIN, 15));
		tutorname.setBounds(407, 360, 100, 40);
		getContentPane().add(tutorname);

		cb = new JTextField();
		cb.setBounds(556, 363, 175, 40);
		getContentPane().add(cb);

		add = new JButton("Add");
		add.setBounds(407, 505, 137, 30);
		add.setFont(new Font("serif", Font.BOLD, 15));
		add.addActionListener(this);
		add.setBackground(new Color(0, 0, 0));
		add.setForeground(new Color(0,0,0));
		getContentPane().add(add);

		edit = new JButton("Edit");
		edit.setBounds(583, 505, 158, 30);
		edit.setFont(new Font("roboto", Font.BOLD, 15));
		edit.addActionListener(this);
		edit.setBackground(Color.BLACK);
		edit.setForeground(Color.BLACK);
		getContentPane().add(edit);

		back = new JButton("Back");
		back.setBounds(583, 561, 152, 30);
		back.setFont(new Font("roboto", Font.BOLD, 15));
		back.addActionListener(this);
		back.setBackground(new Color(0, 0, 0));
		back.setForeground(Color.BLACK);
		getContentPane().add(back);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(198, 136, 156));
		panel.setBounds(0, 0, 343, 667);
		getContentPane().add(panel);
		panel.setLayout(null);

		title = new JLabel("Add Course and Module");
		title.setBounds(0, 303, 343, 40);
		panel.add(title);
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Algerian", Font.BOLD, 26));

		setSize(795, 704);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {

			crname = crsename.getText();
			monam = modname.getText();
			moid = modid.getText();
			yrb = (String) yearA.getSelectedItem();
			yra = (String) sem.getSelectedItem();
			cbx = cb.getText();

			try {
				Connect c = new Connect();
				String str = "Insert into coursetable(Course, Level, Semester, Modules, ModuleCode, Teachername) values('"
						+ crname + "', '" + yrb + "','" + yra + "','" + monam + "','" + moid + "','" + cbx + "')";
				c.s.executeUpdate(str);
				this.dispose();
				new CourseDetail().setVisible(true);

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Course and Module Added Successfully");
			setVisible(false);

		}
		if (e.getSource() == edit) {
			this.dispose();
			new EditCourse().setVisible(true);
		}
		if (e.getSource() == back) {
			this.dispose();
			new AdminPanel().setVisible(true);
		}

	}
}
