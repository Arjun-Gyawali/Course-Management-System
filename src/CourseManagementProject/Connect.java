package CourseManagementProject;

//importing all necessary libraries
import java.sql.*;

public class Connect {
	protected Connection c;
	protected Statement s;

	public Connect() throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3308/course", "root", "");
			s = c.createStatement();
			s.executeUpdate("Create Database if not exists CMS");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
		String url = "jdbc:mysql://localhost:3308/CMS";
		c = DriverManager.getConnection(url, "root", "");
		s = c.createStatement();
		s.executeUpdate("Create Table if not exists Admin(Uname varchar(50),pass varchar(150),Role varchar(50))");
		ResultSet rs = s.executeQuery("SELECT * FROM Admin WHERE Uname!='" + "' ");
		if (!rs.next()) {
			s.executeUpdate("INSERT INTO Admin(Uname, pass, Role) VALUES('admin','admin', 'Admin')");

		}
		s.executeUpdate(
				"Create Table if not exists StudentLogin(name varchar(100), email varchar(150), username varchar(100), pass varchar(50), role varchar(50), ID varchar(10), course varchar(10))");
		s.executeUpdate(
				"Create Table if not exists TeacherLogin(name varchar(100), email varchar(150), username varchar(100), pass varchar(50), role varchar(50), ID varchar(10), course varchar(10))");
		s.executeUpdate(
				"Create Table if not exists CourseTable(Course varchar(50), Level varchar(50) ,Semester varchar(50), Modules varchar(300), ModuleCode varchar(300), Teachername varchar(50))");
		s.executeUpdate(
				"Create Table if not exists result(Semester varchar(50), Modules varchar(300), ModuleCode varchar(300), Studentname varchar(50), Marks Double(4,2), ID varchar(10))");

	}

	public static void main(String[] args) {
		try {
			new Connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
