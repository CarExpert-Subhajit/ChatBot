package code;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;
	@Override
	public void init() throws ServletException {
	loginDao=new LoginDao();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email=request.getParameter("email");
	String password=request.getParameter("pass");
	LoginBean loginBean=new LoginBean();
	loginBean.setEmail(email);
	loginBean.setPassword(password);
	try
	{
	if(loginDao.validate(loginBean))
	{
		HttpSession session=request.getSession(true);
		session.setAttribute("email", email);
		response.sendRedirect("loginsuccess.jsp");
	}else
	{
		HttpSession session=request.getSession();
		session.setAttribute("em", email);
		request.setAttribute("message", "Invalid username or password");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	}

}











