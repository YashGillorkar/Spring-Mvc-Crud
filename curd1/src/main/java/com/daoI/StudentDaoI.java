package com.daoI;

import java.util.List;

import com.model.Student;

public interface StudentDaoI {

	
	public void saveData(Student s);

	public List<Student> loginStudent(String username, String password);
}
