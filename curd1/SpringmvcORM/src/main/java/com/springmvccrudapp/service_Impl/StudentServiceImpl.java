package com.springmvccrudapp.service_Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.springmvccrudapp.StudentDao_interface.StudentDao_I;
import com.springmvccrudapp.model.Student;
import com.springmvccrudapp.service_interface.StudentServiceI;

@Service
public class StudentServiceImpl implements StudentServiceI {
    
	@Autowired
	StudentDao_I sd;
	@Override
	public void saveStudent(Student s) {
		System.out.println("in service");
		sd.saveStudent(s);
		System.out.println("out in service");
	}
	@Override
	public List<Student> stulogin(String username, String password) {
		List<Student> list=sd.stulogin(username, password);
		return list;
	}
	
	


	
	}
