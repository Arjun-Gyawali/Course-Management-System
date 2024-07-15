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
public class InsertMarks extends JFrame implements ActionListener {

	// declaring varibales for GUI representation
	private JLabel l1, l2, l3, l4, lab, l5, l6;
	private JTextField t4, t5, t6;
	private JButton b1, b2;
	private JComboBox combox1, combox2, combo;
	private String sem, mod, modid;
	private JPanel panel;

	InsertMarks() {
		super("Add Marks");
		getContentPane().setBackground(new Color(235, 248, 164));
		setBackground(Color.BLACK);

		l1 = new JLabel("Semester");
		l1.setFont(new Font("Dialog", Font.PLAIN, 15));
		l1.setBounds(444, 422, 78, 30);
		getContentPane().add(l1);
		String aray[] = null;
		try {
			Connect c = new Connect();
			String a = "Select Semester from courseTable";
			ResultSet rs = c.s.executeQuery(a);
			ArrayList<String> list = new ArrayList<>();
			int x = 0;
			while (rs.next()) {

				if (!list.contains(rs.getString("Semester"))) {
					list.add(rs.getString("Semester"));

				}

			}
			aray = (String[]) list.toArray(new String[list.size()]);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		combo = new JComboBox(aray);
		combo.setBounds(622, 422, 150, 30);
		getContentPane().add(combo);

		l2 = new JLabel("Module");
		l2.setFont(new Font("Dialog", Font.PLAIN, 15));
		l2.setBounds(444, 111, 100, 30);
		getContentPane().add(l2);
		String array1[] = null;
		try {
			Connect c1 = new Connect();
			String w = "Select Modules from coursetable";
			ResultSet as = c1.s.executeQuery(w);
			ArrayList<String> list = new ArrayList<>();
			int n = 0;
			while (as.next()) {

				if (!list.contains(as.getString("Modules"))) {
					list.add(as.getString("Modules"));

				}

			}
			array1 = (String[]) list.toArray(new String[list.size()]);
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		combox1 = new JComboBox(array1);
		combox1.setBounds(622, 111, 150, 30);
		getContentPane().add(combox1);

		l3 = new JLabel("Module ID");
		l3.setFont(new Font("Dialog", Font.PLAIN, 15));
		l3.setBounds(444, 353, 100, 30);
		getContentPane().add(l3);
		String array2[] = null;
		try {
			Connect c2 = new Connect();
			String t = "Select ModuleCode from coursetable";
			ResultSet as = c2.s.executeQuery(t);
			ArrayList<String> list = new ArrayList<>();
			int u = 0;
			while (as.next()) {

				if (!list.contains(as.getString("ModuleCode"))) {
					list.add(as.getString("ModuleCode"));

				}

			}
			array2 = (String[]) list.toArray(new String[list.size()]);
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		combox2 = new JComboBox(array2);
		combox2.setBounds(622, 366, 150, 30);
		getContentPane().add(combox2);

		l4 = new JLabel("Student Name");
		l4.setFont(new Font("Dialog", Font.PLAIN, 15));
		l4.setBounds(444, 169, 100, 30);
		getContentPane().add(l4);
		t4 = new JTextField();
		t4.setBounds(622, 170, 150, 30);
		getContentPane().add(t4);

		l5 = new JLabel("Marks \tObtained");
		l5.setFont(new Font("Dialog", Font.PLAIN, 15));
		l5.setBounds(444, 299, 135, 30);
		getContentPane().add(l5);
		t5 = new JTextField();
		t5.setBounds(622, 300, 150, 30);
		getContentPane().add(t5);

		l6 = new JLabel("Student ID");
		l6.setFont(new Font("Dialog", Font.PLAIN, 15));
		l6.setBounds(444, 228, 100, 30);
		getContentPane().add(l6);
		t6 = new JTextField();
		t6.setBounds(622, 229, 150, 30);
		getContentPane().add(t6);

		b1 = new JButton("Enter marks");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.BLACK);
		b1.setFocusable(false);
		b1.setBounds(444, 489, 150, 30);
		b1.addActionListener(this);
		getContentPane().add(b1);

		b2 = new JButton("Cancel");
		b2.setBackground(new Color(0, 0, 0));
		b2.setForeground(Color.BLACK);
		b2.setFocusable(false);
		b2.setBounds(622, 489, 150, 30);
		b2.addActionListener(this);
		getContentPane().add(b2);

		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(198, 136, 156));
		panel.setBounds(0, 0, 364, 646);
		getContentPane().add(panel);
		panel.setLayout(null);

		lab = new JLabel("Fill the data below to add marks");
		lab.setForeground(new Color(255, 255, 255));
		lab.setBounds(10, 292, 344, 30);
		panel.add(lab);
		lab.setFont(new Font("Serif", Font.BOLD, 25));
		setSize(856, 667);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			try {
				sem = (String) combo.getSelectedItem();
				mod = (String) combox1.getSelectedItem();
				modid = (String) combox2.getSelectedItem();
				Connect c = new Connect();
				String s = "Insert into result(Semester,Modules, ModuleCode, Studentname, Marks, ID) values('" + sem
						+ "', '" + mod + "', '" + modid + "', '" + t4.getText() + "','" + t5.getText() + "','"
						+ t6.getText() + "')";
				c.s.executeUpdate(s);

			} catch (SQLException ex) {

			}
			JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
			setVisible(false);
			new EnterMarks().setVisible(true);
		}
		if (e.getSource() == b2) {
			this.dispose();
			new EnterMarks();
		}

	}
}
