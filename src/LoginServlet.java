

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;
import beans.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		UserBean user=(UserBean)session.getAttribute("user");
		if(user==null) {
			user=new UserBean();
		}
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		String nextPage;
		UserBean us=UserDao.certificate(userid,password);
		
		
		if(us!=null){
			nextPage="tweet.jsp";
		}else {
			nextPage="login.jsp";
		}
		session.setAttribute("user",us);
		RequestDispatcher rd=request.getRequestDispatcher(nextPage);
		rd.forward(request,response);
		
	}

}
