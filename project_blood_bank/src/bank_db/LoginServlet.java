package bank_db;

import java.io.IOException
;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login_form")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LoginDao l = new LoginDao();
    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String type=request.getParameter("user");
		Login log = new Login();
		log.setUser(id);
		log.setPass(pass);
		log.setType(type);
		String call=l.check_db(log);
		
		RequestDispatcher dis = request.getRequestDispatcher(call);
		dis.forward(request, response);
	}

}
