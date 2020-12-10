package Coursems;

import java.util.ArrayList;
import java.util.List;

public class Courses {
		private String name;
		private int max_stud;
		private Professor professor;
		private List<Student> students;
		
		public Courses(String name, int max_stud, Professor professor, List<Student> students) {
			this.name = name;
			this.max_stud = max_stud;
			this.professor = professor;
			this.students = new ArrayList<Student>();
		}
		public Professor getProfessor() {
			return professor;
		}
		public void setProfessor(Professor professor) {
			this.professor = professor;
		}
		public List<Student> getStudents() {
			return students;
		}
		public void setStudents(List<Student> students) {
			this.students = students;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getMax_stud() {
			return max_stud;
		}
		public void setMax_stud(int max_stud) {
			this.max_stud = max_stud;
		}
		public ArrayList student_enroll(ArrayList<Student> stud,Student stud1)
		{	
		/*{	if (stud.size() == 0) {
            	stud.add(stud1);
            	return stud;
   	
        }*/
        /*if (stud.size() == max_stud)
            return null;*/
        for(Student s : stud)
        {
			if(s.getName().equals(stud1.getName()))
			{
				break;
			}
			else
			{
				stud.add(stud1);
			}
		}
        return stud;
				
		}
		public ArrayList student_unenroll(ArrayList<Student> stud,Student stud1)
		{
			for(Student s : stud)
	        {
				if(s.getName().equals(stud1.getName()))
				{
					stud.remove(stud1);
				}
				else
				{
					break;
				}
			}
	        return stud;
		}
		public ArrayList<Courses> modify(String name,int max_stud, Professor prof, ArrayList<Courses> al_of_c)
		{	
			for(Courses c : al_of_c)
			{
				if(c.name.equals(name))
				{
					c.max_stud = max_stud;
					c.professor = prof;
					break;
				}
			}
			return al_of_c;				
		}
		
		public void showStudent(ArrayList<Courses> al_of_c) {
			for(Courses c : al_of_c)
			{
				 System.out.println("------------Student Details-------------");
			     System.out.println(c.name);
			     System.out.println(c.max_stud);
			     System.out.println("Courses Enrolled");
			     for(Student s : c.students)
			     {
			    	 System.out.println(s.getName());
			     }	
			}
		}
}
