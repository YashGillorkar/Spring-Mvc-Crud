package com.springmvccrudapp.service_interface;

import java.util.List;

import com.springmvccrudapp.model.Student;

public interface StudentServiceI {
	
	public void saveStudent(Student s);
	public List<Student> stulogin(String username,String password);

}
