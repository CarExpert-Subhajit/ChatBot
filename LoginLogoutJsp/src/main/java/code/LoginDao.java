package code;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class LoginDao {
public boolean validate(LoginBean loginBean) throws ClassNotFoundException
{
	boolean status=false;
	Class.forName("com.mysql.jdbc.Driver");
	try
	(
	Connection connection=DriverManager
			.getConnection("jdbc:mysql://localhost:3306/dummy?useSSL=false","root","");
	PreparedStatement preparedStatement=connection
			.prepareStatement("select * from users where email=? and password=?"))
{
	preparedStatement.setString(1, loginBean.getEmail());
	preparedStatement.setString(2, loginBean.getPassword());
	ResultSet rs=preparedStatement.executeQuery();
	status=rs.next();
}
	catch (Exception e) {
		e.printStackTrace();
	}
	return status;
}
}
