
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	try
	{
		Connection conn=DAO.connect();
		String sql="select * from register";
		PreparedStatement st=conn.prepareStatement(sql);
		out.println("<table width='50%' border=1>");
		out.println("<h1>Employee Details</h1>");
		ResultSet rs=st.executeQuery();
		out.println("<br>");
		ResultSetMetaData rsmd=rs.getMetaData();
		String col1="Edit";
		String col2="Delete";
		int total=rsmd.getColumnCount();
		out.println("<tr>");
		for(int i=1;i<=total;i++)
		{
		out.print("<th>"+rsmd.getColumnName(i)+"</th>");	
		}
		out.println("<th>"+col1+"</th>");
		out.println("<th>"+col2+"</th>");
		out.println("</tr>");
		while(rs.next())
		{
			out.println("<tr><td>"+rs.getInt(1)+""
					+ "</td><td>"+rs.getString(2)+""
							+ "</td><td>"+rs.getString(3)+""
									+ "</td><td>"+rs.getString(4)+""
											+ "</td><td>"+rs.getString(5)+""
													+ "</td><td>"+"<a href='Editreturn?data="+
							rs.getInt(1)+"'>Edit</a>"+"</td><td>"+"<a href='Delete?data="+
							rs.getInt(1)+"'>Delete</a>"+"</td></tr>");	
		}
		out.println("</table>");
	}catch (Exception e) {
	e.printStackTrace();
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
