package ChatApp;

import java.util.ArrayList;

public class User extends Member {
	public User(String name, String phno, String address, ArrayList<Integer> g_id) {
	      super(name, phno,address,g_id);
	}


	public User() {
		super();
	}


	@Override
	public ArrayList<Message> sendmessage(ArrayList<Message> al_of_messages, String m, User user_obj, Group grp_obj) {
		int flag = 0;
		for(int gid : user_obj.getG_id())
		{
			if(gid == grp_obj.getGroupid())
			{
				flag = 1;
			}
		}
		if(flag == 1)
		{
			Message m_obj = new Message();
			m_obj.setMessage(m);
			m_obj.setUser(user_obj);
			m_obj.setGroup(grp_obj);
			al_of_messages.add(m_obj);
		}
		else
		{
			System.out.println("Message not sent");
		}
		return al_of_messages;
	}
	

}
