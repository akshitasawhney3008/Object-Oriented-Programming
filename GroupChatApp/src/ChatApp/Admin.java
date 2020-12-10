package ChatApp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Admin extends Member{
	public Admin(String name, String phno, String address, ArrayList<Integer> g_id) {
	      super(name, phno,address,g_id);
	}

	
	public Admin() {
		super();
	}


	public static
	Requestuser requestapproval(ArrayList<Request> req, ArrayList<User> user, ArrayList<Group> group){
		for(Request r : req)
        {
			if(r.getRequststatus()==0)
			{
				String username = r.getUsername();
				ArrayList<Integer> req_gid= new ArrayList<Integer>();
				req_gid=r.getGroupid();
				
				for(User u : user)
				{
					if(u.getName().equals(username))
					{
						if(r.getRequsttyp().equals("ADD"))
						{
							ArrayList<Integer> gid1=new ArrayList<Integer>();
	    			  		gid1=u.getG_id();
	    			  		group=Group.create_group(gid1,group);
	    			  		for(Integer g: r.getGroupid())			  			
	    		  			{
	    			  			gid1.add(g);
	    		  			}
	    			  		Set<Integer> gid_set = new HashSet<>();
	    			  		gid_set.addAll(gid1);
	    			  		gid1.clear();
	    			  		gid1.addAll(gid_set);
	    			  		u.setG_id(gid1);
	    			  		r.setRequstid(1);
						}
						else if(r.getRequsttyp().equals("REMOVE"))
						{
							ArrayList<Integer> gid1=new ArrayList<Integer>();
	    			  		gid1=u.getG_id();			  		
	    			  		for(Integer g: r.getGroupid())			  			
	    		  			{
	    			  			gid1.remove(g);
		    			  		u.setG_id(gid1);
		    			  		r.setRequstid(1);
	    		  			}
						}
						
					}
				}		
			}
		}
		Requestuser RU = new Requestuser();
		RU.req_list = req;
		RU.user_list = user;
		return RU;
	}


	@Override
	public ArrayList<Message> sendmessage(ArrayList<Message> al_of_messages, String m, User user_obj, Group grp_obj) {
		Message m_obj = new Message();
		m_obj.setMessage(m);
		m_obj.setGroup(grp_obj);
		al_of_messages.add(m_obj);
		return al_of_messages;
		}		
}	
