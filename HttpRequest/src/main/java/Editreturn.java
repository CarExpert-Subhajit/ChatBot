

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class Editreturn
 */
@WebServlet("/Editreturn")
public class Editreturn extends HttpServlet {
Connection conn;
PreparedStatement pst;
ResultSet rs;
int row;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String eid=request.getParameter("data");
	int e=Integer.parseInt(eid);
	conn=DAO.connect();
	try {
		pst=conn.prepareStatement("select * from register where id=?");
		pst.setInt(1, e);
		rs=pst.executeQuery();
		while(rs.next())
		{
		out.print("<div class='container'>");
		out.print("<form action='EditServlet' method='post'>");
		out.print("<input type='hidden' id='id' name='id' value='"+rs.getInt("id")+"'>");
		
		out.print("<label for='fname'>First Name</label>");
		out.print("<input type='text' id='fname' name='fname' value='"+rs.getString("fname")+"'>\r\n"
				+ "\r\n"
				+ "<label for='lname'>Last Name</label>\r\n"
				+ "<input type='text' id='lname' name='lname' value='"+rs.getString("lname")+"'>\r\n"
				+ "\r\n"
				+ "<label for='dept'>Department</label>\r\n"
				+ "<select id='dept' name='dept'>\r\n"
				+ "<option value='CSE'>CSE</option>\r\n"
				+ "<option value='ME'>ME</option>\r\n"
				+ "<option value='ECE'>ECE</option>\r\n"
				+ "<option value='EE'>EE</option>\r\n"
				+ "</select>\r\n"
				+ "\r\n"
				+ "<label for='subject'>Subject</label>\r\n"
				+ "<textarea id='subject' name='subject'  style='height: 200px'>'"+rs.getString("subject")+"'</textarea>\r\n"
				+ "\r\n"
				+ "<input type='submit' value='submit'>\r\n"
				+ "</form>\r\n"
				+ "</div>");
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
