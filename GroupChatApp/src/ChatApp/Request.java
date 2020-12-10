package ChatApp;

import java.util.ArrayList;

public class Request {
	public Request(int requstid, String username, ArrayList<Integer> groupid, String requsttyp, int requststatus) {
		super();
		this.requstid = requstid;
		this.username = username;
		this.groupid = groupid;
		this.requsttyp = requsttyp;
		this.requststatus = requststatus;
	}
		
	private int requstid;
	private String username;
	private ArrayList<Integer> groupid=new ArrayList<Integer>();
	private String requsttyp;
	private int requststatus;
	public int getRequstid() {
		return requstid;
	}
	public void setRequstid(int requstid) {
		this.requstid = requstid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public ArrayList<Integer> getGroupid() {
		return groupid;
	}
	public void setGroupid(ArrayList<Integer> groupid) {
		this.groupid = groupid;
	}
	
	public String getRequsttyp() {
		return requsttyp;
	}
	public void setRequsttyp(String requsttyp) {
		this.requsttyp = requsttyp;
	}
	public int getRequststatus() {
		return requststatus;
	}
	public void setRequststatus(int requststatus) {
		this.requststatus = requststatus;
	}
	
}
