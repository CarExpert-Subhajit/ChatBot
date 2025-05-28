import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DAO {
public static Connection connect()
{
	Connection conn=null;
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/uit","root","");
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return conn;
}
}