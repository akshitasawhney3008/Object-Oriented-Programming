package FMS;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
	public static void main(String args[]){
		System.out.println("~!!!!!!WELCOME!!!!!!~");
		int input;
		int in;
		int flag=0;
		String file_name = "users.txt";
		String filename = "complaints.txt";
		String filename1 = "task_for_student_notifications.txt";
		int complaintid = 0;
		while(flag==0)
		{	
			
			System.out.println("Make your selection:");
			System.out.println("1. Registration");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			Scanner sc = new Scanner(System.in);
			input= sc.nextInt();
			if(input==1)
			{
				System.out.println("Enter the UserId:");
				String userid = sc.next();
				Utility Uid = new Utility();
				String msg = Uid.checkuserid(userid, file_name);
				while (msg == "userid already used")
					{
						System.out.println("User Id already exists, Enter the UserId again:");
						userid = sc.next();
						msg = Uid.checkuserid(userid, file_name);
					}
    		  	System.out.println("Enter new password:");
    		  	String password = sc.next();
    		  	System.out.println("Enter your name:");
    		  	String name = sc.next();
    		  	//String[] name_arr = name.split(" ");
    		  	System.out.println("Choose your type of profession:");
    		    //	System.out.println("1. Admin");
    		  	System.out.println("1. Student");
    		  	System.out.println("2. Employee");
    		  	in = sc.nextInt();
   		  		if(in==1)
    			  	{
    			  		System.out.println("Enter your rollnumber");
    			  		String rollno = sc.next();
    			  		System.out.println("Enter your emailid");
    			  		String emailid = sc.next();
    			  		User userob = new User(userid,password,name,in);
        		  		Utility U = new Utility();
        		  		U.appendfile(userob,rollno,emailid,"users.txt");
    			  	}
   		  		
    		  		
    		  
   		  		else if(in==2)
   		  			{
   		  				// Add employee details

				  		System.out.println("Make a choice for type of profession:");
				  		System.out.println("1. Electrician       ");
		    		  	System.out.println("2. Housekeeping      ");
		    		  	System.out.println("3. Horticulture staff");
		    		  	System.out.println("4. Carpenter         ");
		    		  	System.out.println("5. Mason             ");
				  		int typeofprofession = sc.nextInt();
				  		System.out.println("Enter your employee ID");
				  		String employeeid = sc.next();
		   		  		User userob = new User(userid,password,name,in);
		   		  		String profession = null;
		   		  		if(typeofprofession == 1)
		   		  			{
		   		  				 profession = "Electrician";
		   		  			}
		   		  		else if(typeofprofession == 2)
		   		  			{
		   		  				 profession = "Housekeeping";
		   		  			}
			   		  	else if(typeofprofession == 2)
	   		  				{
	   		  					 profession = "Horticultute Staff";
	   		  				}
				   		else if(typeofprofession == 2)
		   		  			{
		   		  				 profession = "Carpenter";
		   		  			}
				   		else if(typeofprofession == 2)
	   		  				{
	   		  					 profession = "Mason";
	   		  				}	
				  		Utility U = new Utility();
				  		U.appendfile(userob,employeeid,profession,"users.txt");
   		  			}
			
				}
			else if(input == 2)
			{
				
				// Add login functionality
				// Login(userid, pass) -> return object or null
				// If 0 then retry else welcome message! and logout option
				System.out.println("Enter the UserId:");
				String userid = sc.next();
    		  	System.out.println("Enter your password:");
    		  	String password = sc.next();
    		  	Utility uob = new Utility();
    		  	User Userob = uob.Login(userid,password,file_name);
    		  	while (Userob == null)
    		  	{
    		  		System.out.println("User Id or password not correct, Enter the UserId and password again:");
    		  		System.out.println("Enter the UserId:");
    				userid = sc.next();
        		  	System.out.println("Enter your password:");
        		  	password = sc.next();
        		  	Userob = uob.Login(userid,password,file_name);
    		  	}
    		  	System.out.println("!!Welcome " + Userob.getName() + " to Facility Management System!!");
    		  	System.out.println("Enter 1 to continue or 2 to Logout");
    		  	int logout = sc.nextInt();
    		  	if(logout == 2)
    		  		{
    		  			System.out.println("You have successfully logged out");
    		  			flag = 1;
    		  			break;
    		  		}
    		  	else if(logout==1)
    		  	{
    		  		if(Userob.getType() == 1)
    		  		{	
    		  			
    		  			System.out.println("!!Student!!");
    		  			System.out.println("Make a choice :                               ");
				  		System.out.println("1. Make a complaint                           ");
		    		  	System.out.println("2. Make a request                             ");
		    		  	System.out.println("3. To view notifications                      ");
		    		  	System.out.println("4. To provide confimation and feedback        ");
		    		  	System.out.println("5. Exit                                       ");
				  		int action = sc.nextInt();
				  		if (action == 1)
				  		{	
				  			complaintid=complaintid+1;
				  			System.out.println("Enter your location");
				  			String location = sc.next();
				  			int typeofservice=1;
				  			System.out.println("Enter the service category from below:");
				  			System.out.println("1. Electrician       ");
			    		  	System.out.println("2. Housekeeping      ");
			    		  	System.out.println("3. Horticulture staff");
			    		  	System.out.println("4. Carpenter         ");
			    		  	System.out.println("5. Mason             ");
					  		int servicecategory = sc.nextInt();
				  			System.out.println("Write your problem below:");
				  			String comments = sc.next();
				  			Complaint compob = new Complaint(complaintid,location, typeofservice ,Long.toString(System.currentTimeMillis()),userid,null,0,servicecategory,comments,0);
				  			Utility Uob = new Utility();
				  			Uob.writecomplaint(compob,filename);
				  		}
				  		if (action == 2)
				  		{	
				  			complaintid = complaintid + 1;
				  			System.out.println("Enter your location");
				  			String location = sc.next();
				  			int typeofservice=2;
				  			System.out.println("Enter the service category from below:");
				  			System.out.println("1. Electrician       ");
			    		  	System.out.println("2. Housekeeping      ");
			    		  	System.out.println("3. Horticulture staff");
			    		  	System.out.println("4. Carpenter         ");
			    		  	System.out.println("5. Mason             ");
					  		int servicecategory = sc.nextInt();
				  			System.out.println("Enter the type of request:");
				  			System.out.println("1. Repair");
				  			System.out.println("2. Upgradation");
				  			int type = sc.nextInt();
				  			if(type == 1)
				  			{
				  				typeofservice = 21;
				  			}
				  			else if(type == 2)
				  			{
				  				typeofservice = 22;
				  			}
				  			System.out.println("Write your requirements below:");
				  			String comments = sc.next();
				  			Complaint compob = new Complaint(complaintid,location, typeofservice ,Long.toString(System.currentTimeMillis()),userid,null, 0,servicecategory,comments,0);
				  			Utility Uob = new Utility();
				  			Uob.writecomplaint(compob,filename);
				  		}
				  		if (action == 3)
				  		{
				  			System.out.println("Here is the list of completed task, please provide confirmation and feedback");
        		  			ArrayList<Complaint> listoftaskcompleted = new ArrayList<Complaint>();
        		  			Utility Uobj = new Utility();
        		  			listoftaskcompleted = Uobj.readtasks(filename);
        		  			for (Complaint C: listoftaskcompleted)
        		  			{
        		  				if(C.getIsvisited() == 0)
        		  				{	
        		  					
        		  					String content = "\n" + C.getComplaintid() +" " + C.getLocation() + " " + C.getTypeofservice() + " " + C.getTime() + " " +C.getUserid() +  " " + C.getEmployeeid() + " " + C.getFlag()+ " " + C.getServicecategory()+ " " + C.getComments() + " " + C.getIsvisited();
    		  						System.out.println(content);
        		  				}
        		  			}
				  		}
				  		if(action==4)
				  		{
				  			ArrayList<Complaint> listoftaskcompleted = new ArrayList<Complaint>();
        		  			Utility Uobj = new Utility();
        		  			listoftaskcompleted = Uobj.readtasks(filename);
        		  			ArrayList<Integer> listofcid = new ArrayList<Integer>();
        		  			System.out.println("Enter the complaint_ids for which you want to provide confirmation and feedback");
        		  			String cid = sc.next();
        		  			String tokens[] = cid.split(" ");
    		    		  	for (String s: tokens)
    		    		  	{
    		    		  		listofcid.add(Integer.parseInt(s));
    		    		  	}
    		    		  	ArrayList<Feedback> listoffeedback = new ArrayList<Feedback>();
    		    		  	for (Integer i: listofcid)
    		    		  	{
    		    		  		for (Complaint C: listoftaskcompleted)
    		    		  		{
    		    		  			if(i == C.getComplaintid()&& C.getIsvisited()==0)
    		    		  				{
    		    		  				 	C.setIsvisited(1);
    		    		  				 	System.out.println("Please provide your valuable feedback");
    		    		  				 	String feedback = sc.next();
    		    		  				 	System.out.println("How would you rate the service between 1(min) to 5(max):");
    		    		  				 	int rating = sc.nextInt();
    		    		  				 	Feedback fobj = new Feedback(C.getComplaintid(), C.getUserid(), feedback, rating);
    		    		  				 	listoffeedback.add(fobj);
    		    		  				}
    		    		  		}
    		    		  	}
    		    		  	for (Feedback F:listoffeedback)
    		    		  	{
    		    		  		Utility uobj = new Utility();
    		    		  		uobj.writefeedback(F, filename1);	
    		    		  	}
    		    		  	int i = 0;
    		  				for (Complaint C : listoftaskcompleted)
    		  				{
    		  					if(i == 0)
    		  					{
    		  						Utility Utiob = new Utility();
    		  						Utiob.writecomplaint_first(C, filename);
    		  					}
    		  					else
    		  					{
    		  						Utility Utiob = new Utility();
    		  						Utiob.writecomplaint(C, filename);
    		  					}
    		  					i++;
    		  				}
				 
    		  		} 
				  		
    		  		}
    		  		
    		  		else if(Userob.getType() == 2)
    		  		{	
    		  			System.out.println("!!Employee!!");
    		  			System.out.println("Make a choice :                               ");
				  		System.out.println("1. View all tasks                             ");
		    		  	System.out.println("2. Update completed tasks                     ");
		    		  	
				  		int action = sc.nextInt();
    		  			if(action == 1)
    		  			{	
    		  				ArrayList<Complaint> listoftasks = new ArrayList<Complaint>();
    		  				Utility utiobj = new Utility();
    		  				listoftasks = utiobj.readtasks(filename);
    		  				for (Complaint compob:listoftasks)
    		  				{
    		  					if (Userob.getUserid().equals(compob.getEmployeeid()) && compob.getFlag()== 0)
    		  					{
    		  						String content = "\n" + compob.getComplaintid() +" " + compob.getLocation() + " " + compob.getTypeofservice() + " " + compob.getTime() + " " +compob.getUserid() +  " " + compob.getEmployeeid() + " " + compob.getFlag()+ " " + compob.getServicecategory()+ " " + compob.getComments() + " " + compob.getIsvisited();
    		  						System.out.println(content);
 
    		  					}
    		  				}
    		  			}
    		  			if (action == 2)
    		  			{
    		  					
    		  				ArrayList<Integer> listofcid = new ArrayList<Integer>();
    		  				System.out.println("Enter the complaint id of the tasks completed");
    		  				String line = sc.next();
    		    		  	String[] str_arr = line.split(" ");
    		    		  	for (String s: str_arr)
    		    		  	{
    		    		  		listofcid.add(Integer.parseInt(s));
    		    		  	}
    		  				ArrayList<Complaint> listoftasks1 = new ArrayList<Complaint>();
    		  				Utility utiobj = new Utility();
    		  				listoftasks1 = utiobj.readtasks(filename);
    		  				for (Integer s: listofcid)
    		  				{
    		  					
    		  					for (Complaint compob:listoftasks1)
    		  						{
    		  							if (compob.getComplaintid() == s && Userob.getUserid().equals(compob.getEmployeeid()) && compob.getFlag() == 0)
    		  								{
    		  									compob.setFlag(1);
    		  									long previousTime = Long.parseLong(compob.getTime());
    		  									if (System.currentTimeMillis() >= previousTime + 24 * 60 * 60 * 1000)
    		  									{
    		  										compob.setTime("-1000");
    		  									}
    		  									//Utility utobj = new Utility();
    		  	    		  					//utobj.writecomplaint(compob,filename2);
    		  								}
    		  						}
    		  				}
    		  				int i = 0;
    		  				for (Complaint C : listoftasks1)
    		  				{
    		  					if(i == 0)
    		  					{
    		  						Utility Utiob = new Utility();
    		  						Utiob.writecomplaint_first(C, filename);
    		  					}
    		  					else
    		  					{
    		  						Utility Utiob = new Utility();
    		  						Utiob.writecomplaint(C, filename);
    		  					}
    		  					i++;
    		  				}	
    		  			}
    		  		}
    		  		
    		  		else
    		  		{
    		  			System.out.println("!!Admin!!");
    		  			System.out.println("Make a choice");
    		  			System.out.println("1. To Assign tasks                                                    ");
    		  			System.out.println("2. To view completed tasks and Request for confirmations and feedbacks");
    		  			System.out.println("3. Track task not completed in time                       ");
    		  			System.out.println("4. View feedbacks							   "); 
    		  			int action = sc.nextInt();
    		  			if(action == 1)
    		  			{
    		  				ArrayList<Complaint> listoftaskassigned = new ArrayList<Complaint>();
    		  				ArrayList<Complaint> listoftasks = new ArrayList<Complaint>();
    		  				ArrayList<User> listofusers = new ArrayList<User>();
    		  				Utility Utob = new Utility();
    		  				listoftasks = Utob.readtasks(filename);
    		  				listofusers = Utob.readfile(file_name);
    		  				for (Complaint C : listoftasks)
    		  				{
    		  					if(C.getServicecategory() == 1)
    		  					{
    		  						for (User U : listofusers)
    		  						{
    		  							if(U.getType() == 2 && ((FMSemployee) U).getTypeofprofession().equals("Electrician"))
    		  							{
    		  								C.setEmployeeid(U.getUserid());
    		  								listoftaskassigned.add(C);
    		  								
    		  							}
    		  						}
    		  						
    		  					}
    		  					else if (C.getServicecategory() == 2)
    		  					{
    		  						for (User U : listofusers)
    		  						{
    		  							if(U.getType() == 2 && ((FMSemployee) U).getTypeofprofession().equals("Housekeeping"))
    		  							{
    		  								C.setEmployeeid(U.getUserid());
    		  								listoftaskassigned.add(C);
    		  							}
    		  						}
    		  					}
    		  					else if (C.getServicecategory() == 3)
    		  					{
    		  						for (User U : listofusers)
    		  						{
    		  							if(U.getType() == 2 && ((FMSemployee) U).getTypeofprofession().equals("Horticulture Staff"))
    		  							{
    		  								C.setEmployeeid(U.getUserid());
    		  								listoftaskassigned.add(C);
    		  							}
    		  						}
    		  					}
    		  					else if (C.getServicecategory() == 4)
    		  					{
    		  						for (User U : listofusers)
    		  						{
    		  							if(U.getType() == 2 && ((FMSemployee) U).getTypeofprofession().equals("Carpenter"))
    		  							{
    		  								C.setEmployeeid(U.getUserid());
    		  								listoftaskassigned.add(C);
    		  							}
    		  						}
    		  					}
    		  					else if (C.getServicecategory() == 5)
    		  					{
    		  						for (User U : listofusers)
    		  						{
    		  							if(U.getType() == 2 && ((FMSemployee) U).getTypeofprofession().equals("Mason"))
    		  							{
    		  								C.setEmployeeid(U.getUserid());
    		  								listoftaskassigned.add(C);
    		  							}
    		  						}
    		  					}
    		  				}
    		  				int i = 0;
    		  				for (Complaint C : listoftaskassigned)
    		  				{
    		  					if(i == 0)
    		  					{
    		  						Utility Utiob = new Utility();
    		  						Utiob.writecomplaint_first(C, filename);
    		  					}
    		  					else
    		  					{
    		  						Utility Utiob = new Utility();
    		  						Utiob.writecomplaint(C, filename1);
    		  					}
    		  					i++;
    		  				}		    		  				
		    		  	}
    		  			
    		  			if(action == 2)
    		  			{
        		  			System.out.println("Here is the list of completed task, please take confirmation from students");
        		  			ArrayList<Complaint> listoftaskcompleted = new ArrayList<Complaint>();
        		  			Utility Uobj = new Utility();
        		  			listoftaskcompleted = Uobj.readtasks(filename);
        		  			for (Complaint C: listoftaskcompleted)
        		  			{
        		  				if(C.getIsvisited() == 0)
        		  				{	
        		  					
        		  					String content = "\n" + C.getComplaintid() +" " + C.getLocation() + " " + C.getTypeofservice() + " " + C.getTime() + " " +C.getUserid() +  " " + C.getEmployeeid() + " " + C.getFlag()+ " " + C.getServicecategory()+ " " + C.getComments() + " " + C.getIsvisited();
    		  						System.out.println(content);
        		  				}
        		  					
        		  			}
    		  			}
    		  			if(action==3)
    		  			{
    		  				ArrayList<Complaint> listoftimeexeededtasks = new ArrayList<Complaint>();
    		  				Utility Uobj = new Utility();
    		  				listoftimeexeededtasks = Uobj.readtasks(filename);
    		  				for(Complaint C: listoftimeexeededtasks)
    		  				{
    		  					if (C.getTime().equals(-1000))
    		  					{
    		  						String content = "\n" + C.getComplaintid() +" " + C.getLocation() + " " + C.getTypeofservice() + " " + C.getTime() + " " +C.getUserid() +  " " + C.getEmployeeid() + " " + C.getFlag()+ " " + C.getServicecategory()+ " " + C.getComments() + " " + C.getIsvisited();
    		  						System.out.println(content);
    		  					}
    		  				}
    		  				
    		  			}
    		  			if(action == 4)
    		  			{
    		  				ArrayList<Feedback> feedbacklist = new ArrayList<Feedback>();
    		  				ArrayList<Feedback> badfeedbacklist = new ArrayList<Feedback>();
    		  				ArrayList<Feedback> goodfeedbacklist = new ArrayList<Feedback>();
    		  				Utility Uobj = new Utility();
    		  				feedbacklist= Uobj.readfeedbacks(filename1);
    		  				for(Feedback feed : feedbacklist)
    		  				{
    		  					if(feed.getRating()<3)
    		  					{
    		  						badfeedbacklist.add(feed);
    		  					}
    		  					else
    		  					{
    		  						goodfeedbacklist.add(feed);
    		  					}
    		  							
    		  				}
    		  				for (Feedback badfeed : badfeedbacklist)
    		  				{
    		  					System.out.println("Below is the list of bad ratings and feedbacks");
    		  					String content = "\n" + badfeed.getComplaintid() +" " + badfeed.getUserid() + " " + badfeed.getFeedback() + " " + badfeed.getRating();
    		  					System.out.println(content);
    		  					
    		  				}
    		  				for (Feedback goodfeed : goodfeedbacklist)
    		  				{
    		  					System.out.println("Below is the list of good ratings and feedbacks");
    		  					String content = "\n" + goodfeed.getComplaintid() +" " + goodfeed.getUserid() + " " + goodfeed.getFeedback() + " " + goodfeed.getRating();
    		  					System.out.println(content);
    		  					
    		  				}
    		  				
    		  					
    		  			}
		    		  }
    		  	}
    		}
			

			else if(input==3)
			{
			flag=1;
			}		
		}
	}
}


