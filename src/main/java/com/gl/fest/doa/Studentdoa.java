package com.gl.fest.doa;

import java.util.List;

import com.gl.fest.model.Student;

public interface Studentdoa {
	
	public void savestudent(Student student);
	public void deletestudent(int id);
	public Student findbyid(int id);
	public List<Student> listall();
	public List<Student>search(String name,String department);
	

}
