package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDao {
	
	public static List<UserBean> getUserLine(){
		List<UserBean>userlist=new LinkedList<UserBean>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Context context=new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/twitter");
			con=ds.getConnection();
			
			String sql="select * from user";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery(sql);
			while(rs.next()) {
				String userid=rs.getString("userid");
				String username=rs.getString("username");
				String password=rs.getString("password");
				userlist.add(new UserBean(userid,username,password));
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
			}catch(SQLException e) {
				System.err.println(e.getMessage());
				return null;
			}
		}
		return userlist;
		
	}
	
	public static UserBean certificate(String userid,String password) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Context context=new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/twitter");
			con=ds.getConnection();
			String sql="select username from user where userid=? and password=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,userid);
			ps.setString(2,password);
			rs=ps.executeQuery();
			String username;
			
			if(rs.next()) {
				username=rs.getString("username");
				return new UserBean(userid,username,password);
				
			}
			return null;
			
			
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
		catch(NamingException e){
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
		
	}
	
	public static boolean register(UserBean user) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Context context=new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/twitter");
			con=ds.getConnection();
			
			String sql="select * from user where userid=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1,user.getUserId());
			rs=ps.executeQuery();
			if(rs.next()) {
				return false;
			}
		
			rs.close();
			ps.close();
		
		
			
			
			sql="insert into user values(?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,user.getUserId());
			ps.setString(2,user.getUserName());
			ps.setString(3,user.getPassword());
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
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
					
				}
				if(con!=null) {
					con.close();
				}
				
			}catch(Exception e) {
				System.err.println(e.getMessage());
				return false;
			}
		}
		
		
			
		}
		
	}


