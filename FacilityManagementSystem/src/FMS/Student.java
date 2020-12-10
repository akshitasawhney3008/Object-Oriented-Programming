package FMS;

import java.util.ArrayList;


public class Student extends User {
	
	private String rollno;
	private String emailid;
	public Student(String userid, String password, String name, int type, String rollno, String emailid) {
		super(userid, password, name, type);
		this.rollno=rollno;
		this.emailid=emailid;
		}
	
	private ArrayList<Complaint> notifications = new ArrayList<Complaint>();
	private ArrayList<Feedback> feedbackandconfirmations= new ArrayList<Feedback>();
	
	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public ArrayList<Complaint> getNotifications() {
		return notifications;
	}

	public void setNotifications(ArrayList<Complaint> notifications) {
		this.notifications = notifications;
	}

	public ArrayList<Feedback> getFeedbackandconfirmations() {
		return feedbackandconfirmations;
	}

	public void setFeedbackandconfirmations(ArrayList<Feedback> feedbackandconfirmations) {
		this.feedbackandconfirmations = feedbackandconfirmations;
	}
	
	public String makeacomplaint(){
		return "Null";

	}
	
	public String makearequest(){
		return "Null";

	}
	
	public String notification(){
		return "Null";
	}
	
	public String providefeedback(){
		return "Null";
	}


}

