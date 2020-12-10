package ChatApp;

import java.util.ArrayList;

public class Group {
	private String groupname;
	private	int groupid;

	
	public Group(String groupname, int groupid) {
		super();
		this.groupname = groupname;
		this.groupid = groupid;
	}
	public Group() {
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public static char c ='a';
	public static ArrayList<Group> create_group(ArrayList<Integer> user_groupid, ArrayList<Group> group){
		for(Integer ug : user_groupid)
		{
			for(Group gr: group)
			{
				int grupid= gr.getGroupid();
				if(ug!=grupid)
				{
					String groupname = "Group" + (c++) + ug;
					Group g = new Group(groupname,ug);
	    			group.add(g);
				}
			}
		}
		return group;
	}
	
	public static Requestuser delete_group(Integer groupid2, ArrayList<Group> group,ArrayList<User> user,ArrayList<Request> req){
		for(Group grup : group)
		  	{
			  	if(grup.getGroupid() == groupid2)
			  	{
			  		for(User u : user)
			  		{
			  			ArrayList<Integer> gid1=new ArrayList<Integer>();
			  			gid1=u.getG_id();	
			  			for(Integer g: gid1)			  			
    		  			{
    			  			gid1.remove(g);
    		  			}
			  		}
			  			group.remove(grup);
		  	    }
		  	}	
			  	
			  	Requestuser RU2 = new Requestuser();
				RU2.req_list = req;
				RU2.user_list = user;
				RU2.group_list = group;		;
				return RU2;
		  	}
}


