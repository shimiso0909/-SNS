package beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class TimeLineBean implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	private String date;
	
	private String time;
	
	
	private String text;
	
	private String userid;
	
	private String username;
	
	public TimeLineBean() {}
	
	public TimeLineBean(String text,String date,String time,String userid,String username) {
		this.date=date;
		this.time=time;
		this.userid=userid;
		this.text=text;
		this.username=username;
	}
	
	public TimeLineBean(String text) {
		this.text=text;
	}
	
	public TimeLineBean(String text,String date,String time) {
		this.text=text;
		this.date=date;
		this.time=time;
	}
	
	public String getUserName() {
		return username;
	}
	
	public String getDate() {
		
		return date;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getUserId() {
		return userid;
	}
	
	public String getText(){
		return text;
	}
	
	public void setDate(String date) {
		this.date=date;
	}
	
	public void setTime(String time) {
		this.time=time;
	}
	
	
	
	public void setText(String text) {
		this.text=text;
	}
	
	public String getDateTime() {
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long t=System.currentTimeMillis();
		String s=f.format(t);
		return s;
		
	}
	public boolean textCheck(String text) {
		if(text.length()>280) {
			return false;
		}
		return true;
	}
	
	
	

}
