package com.springmvccrudapp.StudentDao_Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.springmvccrudapp.StudentDao_interface.StudentDao_I;
import com.springmvccrudapp.model.Student;

@Repository
public class StudentDao_Impl implements StudentDao_I{

	@Autowired
	SessionFactory sf;
	
	@Override
	public void saveStudent(Student s) {
		
		System.out.println("in dao ");
		Session ss=sf.openSession();
		ss.save(s);
		ss.beginTransaction().commit();
		System.out.println("out in dao");
	}

	@Override
	public List<Student> stulogin(String username,String password) {
	Session ss	=sf.openSession();
	if(username.equals("ADMIN") && password.equals("ADMIN"))
	{
		Query<Student> q= ss.createQuery("from Student");
	    List<Student> list=q.getResultList();
	    
	    return list;
	}
	else
	{
	Query<Student> q=ss.createQuery("from Student where username=? and password=?");
	       q.setParameter(0, username);
	       q.setParameter(1, password);
	   List<Student> list = q.getResultList();
	   return list;
	}
		
	}

}
