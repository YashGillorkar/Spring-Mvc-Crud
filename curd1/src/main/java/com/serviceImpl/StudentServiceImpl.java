package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daoI.StudentDaoI;
import com.model.Student;
import com.serviceI.StudentServiceI;

@Service
public class StudentServiceImpl implements StudentServiceI {

	@Autowired
	StudentDaoI sdi;

	@Override
	public void saveData(Student s) {
		sdi.saveData(s);
	}

	@Override
	public List<Student> loginStudent(String username, String password) {
		List<Student> list = sdi.loginStudent(username, password);
		return list;
	}

}
