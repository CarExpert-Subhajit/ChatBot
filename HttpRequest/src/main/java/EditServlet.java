

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String i=request.getParameter("id");
		int ids=Integer.parseInt(i);
		String fn=request.getParameter("fname");
		String ln=request.getParameter("lname");
		String d=request.getParameter("dept");
		String s=request.getParameter("subject");
		try {
			Connection conn=DAO.connect();
			String sql="update register set fname=?,lname=?,dept=?,subject=?"
					+ "where id=?";
			PreparedStatement st=conn.prepareStatement(sql);
			PrintWriter out=response.getWriter();
			pst.setString(1,fn);
			pst.setString(2,ln);
			pst.setString(3,d);
			pst.setString(4,s);
			pst.setInt(5, ids);
			int rs=st.executeUpdate();
			response.setContentType("text/html");
			if(rs==1)
			{					
			out.println("<h1>Data Updated</h1>");
			}else
			{
				out.println("<h1>Data Not Updated</h1>");	
			}
			}catch (Exception e) {
				System.out.println(e);
			}
	}

}
