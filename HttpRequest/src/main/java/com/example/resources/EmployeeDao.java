package com.example.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao {
public int registerEmployee(Employee employee) throws ClassNotFoundException
{
String sql="insert into employee(id,first_name,last_name,"
		+ "username,password,address,contact)"
		+ "values(?,?,?,?,?,?,?)";	
int result=0;
Class.forName("com.mysql.jdbc.Driver");
try(Connection connection=
DriverManager
.getConnection("jdbc:mysql://localhost:3306/demo","root","");
PreparedStatement preparedStatement=connection.prepareStatement(sql)){
		preparedStatement.setString(1,employee.getId());	
		preparedStatement.setString(2, employee.getFirstName());
		preparedStatement.setString(3, employee.getLastName());
		preparedStatement.setString(4, employee.getUsername());		
		preparedStatement.setString(5, employee.getPassword());
		preparedStatement.setString(6, employee.getAddress());
		preparedStatement.setString(7, employee.getContact());
		result=preparedStatement.executeUpdate();
		
}catch (SQLException e) {
	e.printStackTrace();
}
return result;
}
}
