package ChatApp;

import java.util.ArrayList;

public abstract class Member {
	private String name;
	private String phno;
	private String address;
	
	
	private ArrayList<Integer> g_id= new ArrayList<Integer>();
	public Member(String name2, String phno2, String address2, ArrayList<Integer> g_id2) {
		name=name2;
		phno=phno2;
		address=address2;
		g_id=g_id2;
	}
	public Member() {
		
	}
	public abstract ArrayList<Message> sendmessage(ArrayList<Message> al_of_messages, String m, User user_obj, Group grp_obj);
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ArrayList<Integer> getG_id() {
		return g_id;
	}
	public void setG_id(ArrayList<Integer> g_id) {
		this.g_id = g_id;
	}

}
