

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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
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
		try
		{
			pst=conn.prepareStatement("delete from register where id=?");
			pst.setInt(1, e);
			row=pst.executeUpdate();
			if(row==1)
			{
			response.sendRedirect("ViewServlet");	
			}
		}catch (Exception e2) {
			e2.printStackTrace();
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
