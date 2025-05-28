

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RecData")
public class RecData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fn=request.getParameter("fname");
		String ln=request.getParameter("lname");
		String d=request.getParameter("dept");
		String s=request.getParameter("subject");
		try {
		Connection conn=DAO.connect();
		String sql="insert into register(fname,lname,department,subject)"
				+ "values('"+fn+"','"+ln+"','"+d+"','"+s+"')";
		PreparedStatement st=conn.prepareStatement(sql);
		int rs=st.executeUpdate();
		PrintWriter out=response.getWriter();
		if(rs==1)
		{		
		response.setContentType("text/html");
		out.println("<h1>Data Inserted</h1>");
		}else
		{
			out.println("<h1>Data Not Inserted</h1>");	
		}
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
