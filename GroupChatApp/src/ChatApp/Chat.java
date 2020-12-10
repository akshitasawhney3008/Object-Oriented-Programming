package ChatApp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Chat {
	//static String[] param;
	
	static int count=0;
	static char c = 'a';
	static ArrayList<Request> request = new ArrayList<Request>();
	static ArrayList<User> user = new ArrayList<User>();
	static ArrayList<Group> group = new ArrayList<Group>();
	static ArrayList<Message> message = new ArrayList<Message>();
	
	
	public static void main(String args[]) {
		int	choice;
        //Declare input as scanner
       
	  	
//	  	ArrayList<Integer> G_id=new ArrayList<Integer>();
//	  	for(int i = 3; i < str_arr.length; i++)
//	  	{
//	  		G_id.add(Integer.parseInt(str_arr[i]));
//	  	}
	  	
        System.out.println("Enter choice of commands as given below:");
        System.out.println("Enter 1 for request to create a user / add user to a group.");
        System.out.println("Enter 2 for request to remove from a group.");
        System.out.println("Enter 3 to approve request");
        System.out.println("Enter 4 to Create group.");
        System.out.println("Enter 5 to Delete group.");
        System.out.println("Enter 6 to Sendmessage as a user");
        System.out.println("Enter 7 to Sendmessage as an admin");
        System.out.println("Enter 8 to Display message for the user");
        System.out.println("Enter 9 to Display message for the admin");
        
        Scanner scan = new Scanner(System.in); 
        choice = scan.nextInt();
        while(choice != 9)
        {
    		switch(choice){
    		case 1:
    			Scanner mysc = new Scanner(System.in);
    			System.out.println("You are a user");
    	        System.out.print("Enter the following  details: ");
    		  	System.out.print("UserName Phonenumber Address list_of_gids");
    		  	String line = mysc.nextLine();
    		  	String[] str_arr = line.split(" ");
    		  	String Username = str_arr[0];
    		  	String phnum = str_arr[1];
    		  	String address = str_arr[2];
    		  	ArrayList<Integer> user_gid=new ArrayList<Integer>();
    		 	String gid_str = scan.nextLine();
    		 	String[] gid_arr = gid_str.split(" ");
    		 	for(String s : gid_arr)
    		 	{
    		 		user_gid.add(Integer.parseInt(s));
    		 	}
    		 	
    		 	int flag = 0;
    		  	for(User u : user)
    		  	{
    			  	if(u.getName().equals(Username))
    			  	{	  	
    			  		Request R = new Request(count++,Username,user_gid,"ADD",0);
        		  		request.add(R);
//    			  		ArrayList<Integer> gid1=new ArrayList<Integer>();
//    			  		gid1=u.getG_id();			  		
//    			  		for(Integer g: user_gid)			  			
//    		  			{
//    			  			gid1.add(g);
//    		  			}
//    			  		Set<Integer> gid_set = new HashSet<>();
//    			  		gid_set.addAll(gid1);
//    			  		gid1.clear();
//    			  		gid1.addAll(gid_set);
//    			  		u.setG_id(gid1);
    			  		flag = 1;
    			  	}
    		  	}
    		  	if(flag == 0)
    		  	{
    		  		ArrayList<Integer> null_gid_list = new ArrayList<Integer>();
    		  		User U = new User(Username,phnum,address,null_gid_list);
    		  		user.add(U);
    		  		Request R = new Request(count++,Username,user_gid,"ADD",0);
    		  		request.add(R);
    		  	}
    		  	break;
    		 case 2: 
    			 System.out.println("You are a user");
    			 System.out.print("Enter your name and list of groupids of the group you want to leave ");
    			 String line1 = scan.nextLine();
     		  	 String[] str_arr1 = line1.split(" ");
     		  	 String Username1 = str_arr1[0];
     		  	 ArrayList<Integer> user_gid1=new ArrayList<Integer>();
     		  	 String gid_str1 = scan.nextLine();
     		  	 String[] gid_arr1 = gid_str1.split(" ");
    		 	 for(String s : gid_arr1)
    		 	 {
    		 	    	user_gid1.add(Integer.parseInt(s));
    		 	 }
    		 	
     		  	 for(User u : user)
    		  	 {
    			  	 if(u.getName().equals(Username1))
    			  	 {	  	
    			  		 Request R = new Request(count++,Username1,user_gid1,"REMOVE",0);
        		  		 request.add(R);
    			  	 }
    	
    			 }
     		  	 break;
    		 case 3:
    			 System.out.println("You are the admin");
    			 for(Request r : request)
    			 {
    				
    				// Check all gids from request object wrt the group list
    				// For all new ids call method to create group object
    				// Requrst obj -> user id
    				// User id -> user list -> user object
    				// user obj -> group list -> gids add new- in admin
    				// admin list -> user obj add
    				 
    				Requestuser RU = new Requestuser();
    				// Send admin obj as well and perform a check
    				RU=Admin.requestapproval(request, user, group);
    				request=RU.req_list;
    				user=RU.user_list;     						
    			 }
    			 break;
    		 case 4:
    			 System.out.println("You are the admin");
    			 System.out.println("Enter the GroupId");
    			 String line2 = scan.nextLine();
    			 Integer groupid = Integer.parseInt(line2);
    			 String groupname = "Group" + (c++) + groupid;
    			 Group g = new Group(groupname,groupid);
    			 group.add(g);
    			break;
    		 case 5:
    			 System.out.println("You are the admin");
    			 System.out.println("Enter the GroupId");
    			 String line3 = scan.nextLine();
    			 Integer groupid1 = Integer.parseInt(line3);
    			 Requestuser RU1 = new Requestuser();
    			 RU1=Group.delete_group(groupid1,group,user,request);
    			 break;
    		 case 6:
    			 System.out.println("Enter your username and groupid");
    			 String line4 = scan.nextLine();
     		  	 String[] str_arr2 = line4.split(" ");
     		  	 String uname = str_arr2[0];
     		  	 Integer gid = Integer.parseInt(str_arr2[1]);
     		  	 User uobj=new User();
     		  	 Group gobj=new Group();
     		  	 for(User u: user)
     		  	 {
     		  		 if(uname.equals(u.getName()))
     		  		 { 
     		  			 uobj=u;
     		  		 }
     		  		 else
     		  		 {
     		  			System.out.println("You are not a User please become one before sending any messages");
     		  		 }
     		  	 }
     		  	 for(Group g1:group)
     		  	 {
     		  		 if(gid.equals(g1.getGroupid()))
     		  		 {
     		  			gobj=g1;
     		  		 }
     		  		 else
     		  		 {
     		  			 System.out.println("This is an invalid groupid");
     		  		 }
     		  	 }
     		  		 System.out.println("Enter your message");
     		  		 String line5 = scan.nextLine();
     				 User u_obj= new User();
		  			 message=u_obj.sendmessage(message, line5, uobj, gobj);     		  	
		  			 break;
		  		case 7:
		  			System.out.println("You will be sending messages as an admin");
		  			System.out.println("Enter the groupid in which you want to send message");
		  			String line6 = scan.nextLine();
	     		  	Integer gid1 = Integer.parseInt(line6);
	     		  	Group gobj1=new Group();
		  			for(Group g1:group)
	     		  	 {
	     		  		 if(gid1.equals(g1.getGroupid()))
	     		  		 {
	     		  			gobj1=g1;
	     		  		 }
	     		  		 else
	     		  		 {
	     		  			 System.out.println("This is an invalid groupid");
	     		  		 }
	     		  	 }
		  			System.out.println("Enter your message");
    		  		String line7 = scan.nextLine();
    		  		Admin a_obj= new Admin();
		  			message=a_obj.sendmessage(message, line7, null, gobj1);     		  	
		  			break;
		  		case 8:
		  			System.out.println("You are a User");
		  			System.out.println("Enter your username and the groupid for which you want to see the messages");
		  			String line8= scan.nextLine();
		  			String[] str_arr3 = line8.split(" ");
	     		  	String unme = str_arr3[0];
	     		  	Integer gid2 = Integer.parseInt(str_arr3[1]);
		  			for(Message m: message)
		  			{
		  				User uobjct= new User();
		  				uobjct=m.getUser();
		  				if(unme.equals(uobjct.getName()));
		  				{
		  					Group grupobjct =new Group();
		  					grupobjct=m.getGroup();
		  					if(gid2.equals(grupobjct.getGroupid()));
		  					System.out.println(m.getMessage());
		  				}
		  			}
		  			System.out.println("No messages for you ");
		  			break;
		  		case 9:
		  			System.out.println("You are an admin");
		  			System.out.println("Enter the groupid for which you want to see the mesages");
		  			String line0 = scan.nextLine();
		  			Integer grpid= Integer.parseInt(line0);
		  			for(Message m: message)
		  			{
		  				Group grupobjct1 =new Group();
	  					grupobjct1=m.getGroup();
	  					if(grpid.equals(grupobjct1.getGroupid()));
	  					System.out.println(m.getMessage());
		  			}
		  		case 10:
		  			System.out.println("bbyye");
		  			System.exit(1);
		  		default:
		  			System.out.println("Invalid choice");
		  			
		  			
     		  		 
        	System.out.println("Enter choice of commands as given below:");
            System.out.println("Enter 1 for request to create a user / add user to a group.");
            System.out.println("Enter 2 for request to remove from a group.");
            System.out.println("Enter 3 to approve request");
            System.out.println("Enter 4 to Create a group");
            System.out.println("Enter 5 to Delete a group");
            System.out.println("Enter 6 to Sendmessage.");
            System.out.println("Enter 7 to Sendmessage as an admin");
            System.out.println("Enter 8 to Display message for the user");
            System.out.println("Enter 9 to Display message for the admin");
            
            choice = scan.nextInt();
        }
    		
	 }
	}
}
			  			
			  	
			  	

		
			  	
	

