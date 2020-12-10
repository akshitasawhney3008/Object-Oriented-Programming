package Coursems;

import java.util.ArrayList;
import java.util.List;

public class Professor {
	private String name;
	private String aoe;
	private List<Courses> assignd_courses;
	
	public Professor(String name,String aoe)
	{
		this.name=name;
		this.aoe=aoe;
		this.assignd_courses= new ArrayList<Courses>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAoe() {
		return aoe;
	}

	public void setAoe(String aoe) {
		this.aoe = aoe;
	}

	public List<Courses> getAssignd_courses() {
		return assignd_courses;
	}

	public void setAssignd_courses(List<Courses> assignd_courses) {
		this.assignd_courses = assignd_courses;
	}
	public ArrayList assignCourses(List<Courses> courses,Course course){
		if(assignd_courses.contains(course))
			return "Course alredy assigned";
		else
			assignd_courses.add(course);
		return "S";
		
	}
	public String unassignCourse(Courses course) {
        if (assignd_courses.contains(course))
            assignd_courses.remove(course);
        else
            return "Course not assigned to prof";
        return "S";
    }

    public void showProf(ArrayList<Professor> al_of_p) {
    	for(Professor p : al_of_p){
        System.out.println("------------Professor Details-------------");
        System.out.println(p.name);
        System.out.println(p.aoe);
        System.out.println("Courses Assigned");
        for (Courses curr : p.assignd_courses)
            System.out.println(curr.getName());
    }
}
}
