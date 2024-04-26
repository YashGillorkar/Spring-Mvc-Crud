package com.serviceI;

import java.util.List;

import com.model.Student;

public interface StudentServiceI {
	
	public void saveData(Student s);
	public List<Student> loginStudent(String username,String password);

}
