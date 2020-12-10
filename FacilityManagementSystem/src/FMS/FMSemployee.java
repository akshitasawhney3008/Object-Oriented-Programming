package FMS;

import java.util.ArrayList;

public class FMSemployee extends User {
	
	private String typeofprofession;
	private String employeeid;
	public FMSemployee(String userid, String password, String name, int type,  String employeeid, String typeofprofession) {
		super(userid, password, name, type);
		this.typeofprofession = typeofprofession;
		this.employeeid = employeeid;
	}
	
	private ArrayList<Complaint> listoftaskassigned = new ArrayList<Complaint>();
	private ArrayList<Complaint> listoftaskcompleted = new ArrayList<Complaint>();
	private ArrayList<Complaint> listoftasknotcompleted= new ArrayList<Complaint>();
	private ArrayList<Feedback> badfeedback= new ArrayList<Feedback>();
	
	public ArrayList<Complaint> getListoftaskassigned() {
		return listoftaskassigned;
	}
	public void setListoftaskassigned(ArrayList<Complaint> listoftaskassigned) {
		this.listoftaskassigned = listoftaskassigned;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getTypeofprofession() {
		return typeofprofession;
	}
	public void setTypeofprofession(String typeofprofession) {
		this.typeofprofession = typeofprofession;
	}
	public ArrayList<Complaint> getListoftaskcompleted() {
		return listoftaskcompleted;
	}
	public void setListoftaskcompleted(ArrayList<Complaint> listoftaskcompleted) {
		this.listoftaskcompleted = listoftaskcompleted;
	}
	public ArrayList<Complaint> getListoftasknotcompleted() {
		return listoftasknotcompleted;
	}
	public void setListoftasknotcompleted(ArrayList<Complaint> listoftasknotcompleted) {
		this.listoftasknotcompleted = listoftasknotcompleted;
	}
	public ArrayList<Feedback> getBadfeedback() {
		return badfeedback;
	}
	public void setBadfeedback(ArrayList<Feedback> badfeedback) {
		this.badfeedback = badfeedback;
	}

}
