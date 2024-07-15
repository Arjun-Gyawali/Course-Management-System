package CourseManagementProject;

//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;

//Extending JFrame as Parent Class
public class SeeResult extends JFrame implements ActionListener {
	// declaring varibales for GUI representation
	JTable t1;
	JLabel l1, l2;
	JButton b1, b2;
	private JPanel panel;

	SeeResult() {

		super("ResultSlip");
		getContentPane().setBackground(new Color(235, 248, 164));

		String data[][] = new String[15][8];
		String column[] = { "Semester", "Modules", "ModuleID", "Student Name", "Student ID", "Marks" };
		int i = 0, j = 0;

//      l2 = new JLabel("Enter StudentId to print the result : ");
//      l2.setBounds(50,380,400,30);
//      l2.setFont(new Font("serif",Font.BOLD,23));
//      add(l2);
//
//      box = new JTextField();
//      box.setBounds(420,380,200,40);
//      add(box);

		try {
			Connect c1 = new Connect();
			String s1 = "select * from result";
			ResultSet rs = c1.s.executeQuery(s1);
			while (rs.next()) {
				data[i][j++] = rs.getString("Semester");
				data[i][j++] = rs.getString("Modules");
				data[i][j++] = rs.getString("ModuleCode");
				data[i][j++] = rs.getString("Studentname");
				data[i][j++] = String.valueOf(rs.getDouble("Marks"));
				data[i][j++] = rs.getString("ID");
				i++;
				j = 0;
			}
			t1 = new JTable(data, column);

		} catch (Exception e) {
			e.printStackTrace();
		}
		JScrollPane sp = new JScrollPane(t1);
		sp.setBounds(325, 136, 495, 245);
		getContentPane().add(sp);

		b1 = new JButton("Print");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.BLACK);
		b1.setFocusable(false);
		b1.setBounds(576, 404, 114, 30);
		getContentPane().add(b1);
		b1.addActionListener(this);

		b2 = new JButton("Cancel");
		b2.setBackground(new Color(0, 0, 0));
		b2.setForeground(Color.BLACK);
		b2.setFocusable(false);
		b2.setBounds(700, 404, 120, 30);
		getContentPane().add(b2);
		b2.addActionListener(this);

//      upgrade = new JButton("Upgrade Level");
//      upgrade.setBackground(Color.BLACK);
//      upgrade.setForeground(Color.WHITE);
//      upgrade.setFocusable(false);
//      upgrade.setBounds(500,500,120,30);
//      add(upgrade);
//      upgrade.addActionListener( this);

		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(198, 136, 156));
		panel.setBounds(-13, -54, 303, 665);
		getContentPane().add(panel);
		panel.setLayout(null);

		l1 = new JLabel("Result of Students");
		l1.setForeground(new Color(255, 255, 255));
		l1.setBounds(23, 290, 259, 40);
		panel.add(l1);
		l1.setFont(new Font("Algerian", Font.BOLD, 25));
		setSize(859, 613);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1) {
			try {
				t1.print();
			} catch (PrinterException ex) {

			}
		}
		if (e.getSource() == b2) {
			this.dispose();
			new AdminPanel().setVisible(true);
		}

	}

}
