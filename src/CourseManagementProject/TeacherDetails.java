package CourseManagementProject;

//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
//import com.jgoodies.forms.factories.DefaultComponentFactory;

//Extending JFrame as Parent Class
public class TeacherDetails extends JFrame implements ActionListener {

	private JLabel delTea, addnew;
	public JTable t1;
	public JButton del, adfac, bck;
	public JTextField id;
	public String column[] = { "Name", "Email", "Username", "Password", "ID", "Course" };
	public String data[][] = new String[20][13];
	private int i = 0, j = 0;
	private JLabel lblNewLabel;

	TeacherDetails() {
		super("Teacher Details");
		setSize(1026, 610);
		setLocation(200, 200);
		getContentPane().setLayout(null);

		delTea = new JLabel("Enter teacher id to delete");
		delTea.setBounds(341, 449, 200, 30);
		delTea.setFont(new Font("Dialog", Font.BOLD, 15));
		getContentPane().add(delTea);

		id = new JTextField();
		id.setBounds(611, 449, 200, 30);
		getContentPane().add(id);

		del = new JButton("Delete");
		del.setBackground(new Color(0, 0, 0));
		del.setForeground(Color.BLACK);
		del.setBounds(845, 448, 100, 30);
		getContentPane().add(del);

		addnew = new JLabel("Add New Teacher");
		addnew.setBounds(332, 92, 177, 30);
		addnew.setFont(new Font("Dialog", Font.BOLD, 15));
		getContentPane().add(addnew);

		adfac = new JButton("Add Teacher");
		adfac.setBackground(Color.BLACK);
		adfac.setForeground(Color.BLACK);
		adfac.setBounds(795, 92, 150, 30);
		getContentPane().add(adfac);
		
		bck = new JButton("Back");
		bck.setFocusable(false);
		bck.setBounds(851, 500, 100, 34);
		bck.setFont(new Font("roboto", Font.BOLD, 15));
		bck.setBackground(Color.BLACK);
		bck.setForeground(Color.BLACK);
		bck.addActionListener(this::actionPerformed);
		getContentPane().add(bck);


		del.addActionListener(this);
		adfac.addActionListener(this);

		try {
			Connect c1 = new Connect();
			String s1 = "select * from teacherlogin";
			ResultSet rs = c1.s.executeQuery(s1);
			while (rs.next()) {
				data[i][j++] = rs.getString("name");
				data[i][j++] = rs.getString("email");
				data[i][j++] = rs.getString("username");
				data[i][j++] = rs.getString("pass");
				data[i][j++] = rs.getString("ID");
				data[i][j++] = rs.getString("course");
				i++;
				j = 0;
			}
			t1 = new JTable(data, column);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JScrollPane sp = new JScrollPane(t1);
		sp.setBounds(270, 132, 732, 268);
		getContentPane().add(sp);

		getContentPane().setBackground(new Color(235, 248, 164));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(198, 136, 156));
		panel_1.setBounds(0, -19, 267, 818);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel = new JLabel("Teacher Details");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 26));
		lblNewLabel.setBounds(10, 251, 247, 79);
		panel_1.add(lblNewLabel);

		del.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {

		Connect c1 = null;
		try {
			c1 = new Connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (ae.getSource() == bck) {
			this.dispose();
			new AdminPanel().setVisible(true);
		}

		if (ae.getSource() == del) {
			try {
				String a = id.getText();
				String q = "delete from teacherlogin where id = '" + a + "'";
				c1.s.executeUpdate(q);

			} catch (Exception e) {

			}
			this.dispose();
			new TeacherDetails().setVisible(true);

		} else if (ae.getSource() == adfac) {
			this.dispose();
			new AddTeacher().setVisible(true);

		}
	}
}
