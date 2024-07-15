package CourseManagementProject;

//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

//Extending JFrame as Parent Class
public class ViewModule extends JFrame implements ActionListener {

	// declaring varibales for GUI representation
	JTable t1;
	String data[][] = new String[15][8];
	String column[] = { "Semester", "My Subjects", "ModuleID" };
	int i = 0, j = 0;
	String name;
	JButton bck;
	private JPanel panel;
	private JLabel lblNewLabel;

	ViewModule(String name) {

		super("Module Table");
		getContentPane().setBackground(new Color(235, 248, 164));

		this.name = name;
		try {
			Connect c2 = new Connect();
			String s2 = "select * from coursetable where Teachername='" + this.name + "' ";
			ResultSet rs = c2.s.executeQuery(s2);
			while (rs.next()) {
				data[i][j++] = rs.getString("Semester");
				data[i][j++] = rs.getString("Modules");
				data[i][j++] = rs.getString("ModuleCode");
				i++;
				j = 0;
			}
			t1 = new JTable(data, column);
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		JScrollPane sp = new JScrollPane(t1);
		sp.setBounds(233, 131, 423, 208);
		getContentPane().add(sp);

		bck = new JButton("Back");

		bck.setFocusable(false);
		bck.setBounds(556, 349, 100, 40);
		bck.setFont(new Font("roboto", Font.BOLD, 15));
		bck.setBackground(Color.BLACK);
		bck.setForeground(Color.BLACK);
		bck.addActionListener(this::actionPerformed);
		getContentPane().add(bck);

		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(198, 136, 156));
		panel.setBounds(-26, -54, 232, 623);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("Table");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 35));
		lblNewLabel.setBounds(80, 243, 152, 81);
		panel.add(lblNewLabel);
		setSize(698, 540);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == bck) {
			this.dispose();
			// setVisible(true);
		}
	}
}
