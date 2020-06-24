package beans;

import java.io.Serializable;

public class UserBean implements Serializable{
	private static final long serialVersionUID=1L;
	
	String userid;
	
	String username;
	
	String password;
	
	public UserBean() {}
	
	
	public UserBean(String userid,String username,String password) {
		this.userid=userid;
		this.username=username;
		this.password=password;
		
		
	}
	
	
	
	public String getUserId() {
		return userid;
	}
	
	public String getUserName() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setId(String  userid) {
		this.userid=userid;
	}
	
	public void setName(String username) {
		this.username=username;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
}



