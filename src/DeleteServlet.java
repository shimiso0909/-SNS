

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

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 
		
		 String delete=request.getParameter("delete");
		 String dat=request.getParameter("date");
		 String time=request.getParameter("time");
		 
		 HttpSession session=request.getSession();
		 UserBean user=(UserBean)session.getAttribute("user");
		 List<TimeLineBean> list=(List<TimeLineBean>)session.getAttribute("tweet");
		 if(list==null) {
			 list=new LinkedList<TimeLineBean> ();
		 }
		 TimeLineBean de=new TimeLineBean(delete,dat,time,user.getUserId(),user.getUserName());
		 TimeLineDao.delete(de);
		 list=TimeLineDao.getTimeLine();
		 
		 session.setAttribute("tweet",list);
		 
		 
		 RequestDispatcher rd=request.getRequestDispatcher("timeLine.jsp");
		 rd.forward(request,response);
		 
		
		
	}

}
