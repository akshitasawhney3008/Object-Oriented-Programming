package Coursems;

import java.util.ArrayList;
import java.util.List;

class Student {
	   private String name;
	   private Degrees degree;
	   private int year;
	   private List<Courses> ecourses;
	   
	   enum Degrees{
		   Btech,
		   Mtech,
		   PHD
	   }
	   
	   public Student(String name, String deg, int year)
	   {
		   this.name=name;
		   if (deg.equalsIgnoreCase("Btech"))
	            this.degree = Degrees.Btech;
	        else if (deg.equalsIgnoreCase("Mtech"))
	            this.degree = Degrees.Mtech;
	        else if (deg.equalsIgnoreCase("PHD"))
	            this.degree = Degrees.PHD;
		   this.year=year;
		   this.ecourses = new ArrayList<Courses>();

	   }
	   
	   
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Degrees getDegree() {
		return degree;
	}


	public void setDegree(Degrees degree) {
		this.degree = degree;
	}


	public List<Courses> getEcourses() {
		return ecourses;
	}


	public void setEcourses(List<Courses> ecourses) {
		this.ecourses = ecourses;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public ArrayList Enroll(ArrayList<Courses> courses,Courses course,String name){
		for (Student s:)
		{	if (s.name.equals(name))
			if(c.getName().equals(course.getName()))
				break;
			else
				courses.add(course);
		}
			return courses;
					
	}
	
	public ArrayList Unenroll(ArrayList<Courses> courses,Courses course){
		for (Courses c:courses)
		{
			if(c.getName().equals(course.getName()))
				courses.remove(course);
			else
				break;
		}
		return courses;
	}
	public void showStudent(ArrayList<Student> al_of_s) {
		for(Student s : al_of_s)
		{
			 System.out.println("------------Student Details-------------");
		     System.out.println(s.name);
		     System.out.println(s.degree);
		     System.out.println(s.year);
		     System.out.println("Courses Enrolled");
		     for(Courses c : s.ecourses)
		     {
		    	 System.out.println(c.getName());
		     }	
		}
    }
		
}
	 
