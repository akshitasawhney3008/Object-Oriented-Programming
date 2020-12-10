package FMS;

import java.sql.Time;


public class Complaint {
	public Complaint(int complaintid, String location, int typeofservice, String time, String userid,String employeeid, int flag, int servicecategory, String comments, int isvisited) {
		this.complaintid = complaintid;
		this.location = location;
		this.typeofservice = typeofservice;
		this.time = time;
		this.userid = userid;
		this.servicecategory = servicecategory;
		this.comments = comments;
		this.flag = flag;
		this.employeeid = employeeid;
		this.isvisited = isvisited;
	}
	
	public int getIsvisited() {
		return isvisited;
	}
	public void setIsvisited(int isvisited) {
		this.isvisited = isvisited;
	}

	private int complaintid;
	private String location;
	private int typeofservice;
	private String time;
	private String userid;
	private String employeeid;
	private String comments;
	private int flag;
	private int isvisited;
	private int servicecategory;
	
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public int getComplaintid() {
		return complaintid;
	}
	public void setComplaintid(int complaintid) {
		this.complaintid = complaintid;
	}
	public String getUserid() {
		return userid;
	}
	public int getServicecategory() {
		return servicecategory;
	}
	public void setServicecategory(int servicecategory) {
		this.servicecategory = servicecategory;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getLocation() {
		return location;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getTypeofservice() {
		return typeofservice;
	}
	public void setTypeofservice(int typeofservice) {
		this.typeofservice = typeofservice;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
