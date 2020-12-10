package FMS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Utility 
	{
		int input;
		Scanner sc = new Scanner(System.in);
		public String checkuserid(String userid, String filename)
			{	
				ArrayList<User> lousers = new ArrayList<User>();
				lousers = readfile(filename);
				for (User U:lousers)
					{
						if (U.getUserid().equals(userid))
							{
								return "userid already used";
							}
					}
				return "userid is good to go";
		
			}
		public String checkpassword(String userid,String password, String filename)
		{	
			ArrayList<User> lousers1 = new ArrayList<User>();
			lousers1 = readfile(filename);
			for (User U:lousers1)
				{
					if (U.getUserid().equals(userid))
						{	
							if(U.getPassword().equals(password))
							return "correct password";
						}
				}
			return "reenter password";
	
		}
	
		public String appendfile(User userob,String rollno, String emailid ,String filename)
		{	
			BufferedWriter bw = null;
			FileWriter fw = null;
			try
				{
					String content = "\n" + userob.getUserid() + " " + userob.getPassword() + " " + userob.getName() + " " + userob.getType() + " " + rollno + " " + emailid;
					fw = new FileWriter(filename,true);
					bw = new BufferedWriter(fw);
					bw.write(content);
				}
			catch (FileNotFoundException e) 
				{
					System.out.println("File not found");
				}
			catch (IOException e) 
				{
					System.out.println("Error initializing stream");
		  		}
			finally 
			{

				try 
					{

						if (bw != null)
							bw.close();

						if (fw != null)
							fw.close();

					} 
				catch (IOException ex) 
				{

				ex.printStackTrace();

				}

		}
		  	
			return "File is updated";
		}

		public ArrayList<User> readfile(String filename)
		{
			BufferedReader br = null;
			FileReader fr = null;
			ArrayList<User> listofusers = new ArrayList<User>();
			try 
				{
			
					//br = new BufferedReader(new FileReader(FILENAME));
					fr = new FileReader(filename);
					br = new BufferedReader(fr);
			
					String sCurrentLine;
					
					while ((sCurrentLine = br.readLine()) != null)
						{
							String[] readstring;
							
							readstring = sCurrentLine.split(" ");
							if (Integer.parseInt(readstring[3])==1)
								{
									Student studob1 = new Student(readstring[0],readstring[1],readstring[2],Integer.parseInt(readstring[3]),readstring[4],readstring[5]);
									listofusers.add(studob1);
								}
							else if(Integer.parseInt(readstring[3])==2)
								{
									FMSemployee fmsempob = new FMSemployee(readstring[0],readstring[1],readstring[2],Integer.parseInt(readstring[3]),readstring[4],readstring[5]);
									listofusers.add(fmsempob);
								}
							
							else
								{
									Admin adminob = new Admin(readstring[0],readstring[1],readstring[2],Integer.parseInt(readstring[3]));
									listofusers.add(adminob);
								}
						}
					
					
				}
					catch (IOException e) 
					{

						e.printStackTrace();
					}
				finally 
					{
			
						try 
						{
			
							if (br != null)
								br.close();
			
							if (fr != null)
								fr.close();
			
						} 
						catch (IOException ex) 
						{
							ex.printStackTrace();
						}
					}
			return listofusers;
		}	
		
	public User Login(String userid,String password, String filename)
		{
			User Uob = new User(null, null, null, 0);
			String msg = checkuserid(userid, filename);
			String passmsg = checkpassword(userid,password,filename);
			if (msg == "userid is good to go" || passmsg == "reenter password")
			{
				return null;
				
			}
			ArrayList<User> lousers2 = new ArrayList<User>();
			lousers2 = readfile(filename);
			for (User U:lousers2)
			{
				if (U.getUserid().equals(userid))
					{	
						Uob = U;
					}
			}
			return Uob;
		}

	public String writecomplaint_first(Complaint compob,String filename)
	{	
		BufferedWriter bw = null;
		FileWriter fw = null;
		try
			{
				String content = compob.getComplaintid() +" " + compob.getLocation() + " " + compob.getTypeofservice() + " " + compob.getTime() + " " +compob.getUserid() +" " + compob.getEmployeeid() + " " + compob.getFlag()+ " "+ compob.getServicecategory()+ " " + compob.getComments() + " " + 0;
				fw = new FileWriter(filename);
				bw = new BufferedWriter(fw);
				bw.write(content);
			}
		catch (FileNotFoundException e) 
			{
				System.out.println("File not found");
			}
		catch (IOException e) 
			{
				System.out.println("Error initializing stream");
	  		}
		finally 
		{
	
			try 
				{
	
					if (bw != null)
						bw.close();
	
					if (fw != null)
						fw.close();
	
				} 
			catch (IOException ex) 
			{
	
			ex.printStackTrace();
	
			}
	
		}
	  	
		return "File is updated";
	}
	
	public String writecomplaint(Complaint compob,String filename)
	{	
		BufferedWriter bw = null;
		FileWriter fw = null;
		try
			{
				String content = "\n" + compob.getComplaintid() +" " + compob.getLocation() + " " + compob.getTypeofservice() + " " + compob.getTime() + " " +compob.getUserid() +" " + compob.getEmployeeid() + " " + compob.getFlag()+ " "+ compob.getServicecategory()+ " " + compob.getComments() + " " + 0;
				fw = new FileWriter(filename,true);
				bw = new BufferedWriter(fw);
				bw.write(content);
			}
		catch (FileNotFoundException e) 
			{
				System.out.println("File not found");
			}
		catch (IOException e) 
			{
				System.out.println("Error initializing stream");
	  		}
		finally 
		{
	
			try 
				{
	
					if (bw != null)
						bw.close();
	
					if (fw != null)
						fw.close();
	
				} 
			catch (IOException ex) 
			{
	
			ex.printStackTrace();
	
			}
	
		}
	  	
		return "File is updated";
	}
	public ArrayList<Complaint> readtasks(String filename)
	{
		BufferedReader br = null;
		FileReader fr = null;
		ArrayList<Complaint> listoftasks = new ArrayList<Complaint>();
		try 
			{
		
				//br = new BufferedReader(new FileReader(FILENAME));
				fr = new FileReader(filename);
				br = new BufferedReader(fr);
		
				String sCurrentLine;
				
				while ((sCurrentLine = br.readLine()) != null)
					{
						String[] readstring;
						
						readstring = sCurrentLine.split(" ");
						Complaint compob = new Complaint(Integer.parseInt(readstring[0]),readstring[1],Integer.parseInt(readstring[2]),readstring[3],readstring[4],readstring[5],Integer.parseInt(readstring[6]),Integer.parseInt(readstring[7]), readstring[8], Integer.parseInt(readstring[9]));
						listoftasks.add(compob);
	
					}
				
				
			}
				catch (IOException e) 
				{

					e.printStackTrace();
				}
			finally 
				{
		
					try 
					{
		
						if (br != null)
							br.close();
		
						if (fr != null)
							fr.close();
		
					} 
					catch (IOException ex) 
					{
						ex.printStackTrace();
					}
				}
		return listoftasks;
	}	
	public String writefeedback(Feedback feedback,String filename)
	{	
		BufferedWriter bw = null;
		FileWriter fw = null;
		try
			{
				String content = "\n" + feedback.getComplaintid() +" " + feedback.getUserid() + " " + feedback.getFeedback() + " " + feedback.getRating(); 
				fw = new FileWriter(filename,true);
				bw = new BufferedWriter(fw);
				bw.write(content);
			}
		catch (FileNotFoundException e) 
			{
				System.out.println("File not found");
			}
		catch (IOException e) 
			{
				System.out.println("Error initializing stream");
	  		}
		finally 
		{
	
			try 
				{
	
					if (bw != null)
						bw.close();
	
					if (fw != null)
						fw.close();
	
				} 
			catch (IOException ex) 
			{
	
			ex.printStackTrace();
	
			}
	
		}
	  	
		return "File is updated";
	}
	public ArrayList<Feedback> readfeedbacks(String filename)
	{
		BufferedReader br = null;
		FileReader fr = null;
		ArrayList<Feedback> listoffeedback = new ArrayList<Feedback>();
		try 
			{
		
				//br = new BufferedReader(new FileReader(FILENAME));
				fr = new FileReader(filename);
				br = new BufferedReader(fr);
		
				String sCurrentLine;
				
				while ((sCurrentLine = br.readLine()) != null)
					{
						String[] readstring;
						
						readstring = sCurrentLine.split(" ");
						Feedback feedbackobj= new Feedback(Integer.parseInt(readstring[0]),readstring[1],readstring[2],Integer.parseInt(readstring[3]));
						listoffeedback.add(feedbackobj);
					}
				
				
			}
				catch (IOException e) 
				{

					e.printStackTrace();
				}
			finally 
				{
		
					try 
					{
		
						if (br != null)
							br.close();
		
						if (fr != null)
							fr.close();
		
					} 
					catch (IOException ex) 
					{
						ex.printStackTrace();
					}
				}
		return listoffeedback;
	}	
}
