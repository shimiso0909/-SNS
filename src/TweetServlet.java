

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.TimeLineBean;
import beans.TimeLineDao;
import beans.UserBean;
import beans.UserDao;

/**
 * Servlet implementation class TweetServlet
 */
@WebServlet("/TweetServlet")
public class TweetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		long t=System.currentTimeMillis();
		String date=String.format("%tF",t);//yyyy-MM-dd
		String time=String.format("%tT",t);//hh:mm:ss
		
		HttpSession session=request.getSession();
		List<TimeLineBean> list=(List<TimeLineBean>)session.getAttribute("tweet");
		if(list==null) {
			list=new LinkedList<TimeLineBean>();
		}
		List<UserBean> userlist=(List<UserBean>)session.getAttribute("userlist");
		if(userlist==null) {
			userlist=new LinkedList<UserBean>();
		}
		UserBean user=(UserBean)session.getAttribute("user");
		TimeLineBean tweet=new TimeLineBean(request.getParameter("tweet"),date,time,user.getUserId(),user.getUserName());
		TimeLineDao.insert(tweet);
		
		
		userlist=UserDao.getUserLine();
		list=TimeLineDao.getTimeLine();
		
		session.setAttribute("userlist",userlist);
		session.setAttribute("user",user);
		session.setAttribute("tweet",list);
		
		RequestDispatcher rd=request.getRequestDispatcher("timeLine.jsp");
		rd.forward(request,response);
		
		
		
		
	}

}
