package FMS;

public class User {
	private String Userid;
	private String password;
	private String name;
	private int type;
	public User(String userid, String password, String name, int type) {
		Userid = userid;
		this.password = password;
		this.name = name;
		this.type = type;
	}
	public String getUserid() {
		return Userid;
	}
	public void setUserid(String userid) {
		Userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public String Login(){
		return "Null";
	}
	
	public String Logout(){
		return "Null";
	}
	
	public String Registtration(){
		return "Null";
	}
	
	public String forgotorchangepassword(){
		return "Null";
	}
	
}
