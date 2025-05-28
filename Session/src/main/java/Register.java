

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
		HashMap<String, String> userDetails=new HashMap<String, String>();
		userDetails.put("firstname", firstName);
		userDetails.put("lastname", lastName);
		userDetails.put("username", username);
		userDetails.put("password", password);
		userDetails.put("contact", contact);
		userDetails.put("address", address);
		HttpSession session=request.getSession();
		session.setAttribute("user", userDetails);
		RequestDispatcher dispatcher=request.getRequestDispatcher("confirm.jsp");
		dispatcher.forward(request, response);
	}
}


