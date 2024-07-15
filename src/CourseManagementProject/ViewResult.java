package CourseManagementProject;

//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

//Extending JFrame as Parent Class
public class ViewResult extends JFrame implements ActionListener {

	// declaring varibales for GUI representation
	String data[][] = new String[15][8];
	String column[] = { "Semester", "Module", "ModuleID", "Marks Obtained" };
	JLabel result;
	String name;
	JTable table;
	int i = 0, j = 0;
	JButton bck;
	private JPanel panel_1;

	ViewResult(String name) {
		super("Student Individual Result");
		getContentPane().setBackground(new Color(235, 248, 164));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		this.name = name;

		String id = null;
		String que = "Select ID from studentlogin where name='" + this.name + "'";

		try {
			Connect c1 = new Connect();
			ResultSet rs = c1.s.executeQuery(que);
			if (rs.next()) {
				id = rs.getString("ID");
			}
			String str = "Select * from result where ID= '" + id + "'";
			ResultSet res = c1.s.executeQuery(str);
			while (res.next()) {
				data[i][j++] = res.getString("Semester");
				data[i][j++] = res.getString("Modules");
				data[i][j++] = res.getString("ModuleCode");
				data[i][j++] = res.getString("Marks");
				i++;
				j = 0;
			}
			table = new JTable(data, column);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(309, 141, 474, 269);
		getContentPane().add(sp);

		bck = new JButton("Back");
		bck.setFocusable(false);
		bck.setBounds(683, 430, 100, 40);
		bck.setFont(new Font("roboto", Font.BOLD, 15));
		bck.setBackground(Color.BLACK);
		bck.setForeground(Color.BLACK);
		bck.addActionListener(this);
		getContentPane().add(bck);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(198, 136, 156));
		panel_1.setBounds(-15, 0, 281, 664);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		result = new JLabel("Results");
		result.setForeground(new Color(255, 255, 255));
		result.setBounds(82, 270, 150, 30);
		panel_1.add(result);
		result.setFont(new Font("Serif", Font.BOLD, 35));

		setVisible(true);
		setSize(825, 646);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bck) {
			this.dispose();
			new StudentPanel(this.name);
		}
	}
}
