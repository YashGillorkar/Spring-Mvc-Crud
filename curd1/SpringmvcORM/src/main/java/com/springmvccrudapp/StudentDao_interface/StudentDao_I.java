package com.springmvccrudapp.StudentDao_interface;

import java.util.List;

import com.springmvccrudapp.model.Student;

public interface StudentDao_I {
	
	public void saveStudent(Student s);
	public List<Student> stulogin(String username,String password);

}
