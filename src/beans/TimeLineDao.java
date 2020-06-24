package beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TimeLineDao {
	
	public static List <TimeLineBean> getTimeLine(){
		List<TimeLineBean> list=new LinkedList<TimeLineBean>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Context context=new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/twitter");
			con=ds.getConnection();
			
			String sql="select * from timeline order by time desc,date desc";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery(sql);
			while(rs.next()) {
				
				String text=rs.getString("text");
				Time time=rs.getTime("time");
				Date date=rs.getDate("date");
				String tm=time.toString().substring(0,8);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String dt=sdf.format(date);
				String userid=rs.getString("userid");
				String username=rs.getString("username");
				list.add(new TimeLineBean(text,dt,tm,userid,username));
			
			}

		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
		catch(NamingException e) {
			System.err.println(e.getMessage());
			return null;
		}
		finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}
			catch(SQLException e) {
				System.err.println(e.getMessage());
				return null;
			}
		}
		return list;
	}
	public static boolean delete(TimeLineBean de) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Context context=new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/twitter");
			con=ds.getConnection();
			String sql="delete from timeline where text=? and date=? and time=? and userid=? and username=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,de.getText());
			ps.setDate(2,Date.valueOf(de.getDate()));
			ps.setTime(3,Time.valueOf(de.getTime()));
			ps.setString(4,de.getUserId());
			ps.setString(5,de.getUserName());
			int cnt=ps.executeUpdate();
			if(cnt>=1) {
				return true;
			}
			return false;
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		catch(NamingException e) {
			System.err.println(e.getMessage());
			return false;
		}
		finally {
			try {
				if(rs!=null) {
					rs.close();
					
				}
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
				
				
			}catch(SQLException e) {
				System.err.println(e.getMessage());
				return false;
			}
		}
		
	}
	public static boolean insert(TimeLineBean tweet) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Context context=new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/twitter");
			con=ds.getConnection();
			String sql="insert into timeline values(?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,tweet.getText());
			ps.setDate(2,Date.valueOf(tweet.getDate()));
			ps.setTime(3,Time.valueOf(tweet.getTime()));
			ps.setString(4,tweet.getUserId());
			ps.setString(5,tweet.getUserName());
			int cnt=ps.executeUpdate();
			if(cnt==1) {
				return true;
			}
			return false;
			
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		catch(NamingException e) {
			System.err.println(e.getMessage());
			return false;
		}
		finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}
			catch(SQLException e) {
				System.err.println(e.getMessage());
				return false;
			}
		}
	}

}
