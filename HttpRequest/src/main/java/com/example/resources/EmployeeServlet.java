package com.example.resources;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String firstName=request.getParameter("firstname");
	String lastName=request.getParameter("lastname");
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String contact=request.getParameter("contact");
	String address=request.getParameter("address");
	String id=request.getParameter("id");
	Employee employee=new Employee();
	EmployeeDao employeeDao=new EmployeeDao();
	employee.setId(id);
	employee.setFirstName(firstName);
	employee.setLastName(lastName);
	employee.setUsername(username);
	employee.setPassword(password);
	employee.setAddress(address);
	employee.setContact(contact);	
	try
	{
	employeeDao.registerEmployee(employee);
	}catch (Exception e) {
	e.printStackTrace();
	}
	response.sendRedirect("employeedetails.jsp");
	}
}