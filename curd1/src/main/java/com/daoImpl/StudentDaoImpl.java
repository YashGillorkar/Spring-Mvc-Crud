package com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daoI.StudentDaoI;
import com.model.Student;

@Repository
public class StudentDaoImpl implements StudentDaoI {

	@Autowired
	SessionFactory sf;

	@Override
	public void saveData(Student s) {

		Session ss = sf.openSession();
		ss.save(s);
		ss.beginTransaction().commit();
	}

	public List<Student> getStudents() {
		Session session = sf.openSession();
		List<Student> list = session.createQuery("from Student").getResultList();
		return list;
	}

	@Override
	public List<Student> loginStudent(String username, String password) {
		Session session = sf.openSession();
		if (username.equals("ADMIN") & password.equals("ADMIN")) {
			return getStudents();
		} else {
			Query<Student> q = session.createQuery("from Student where username=? and password=?");
			q.setParameter(0, username);
			q.setParameter(1, password);
			List<Student> l = q.getResultList();
			return l;
		}
	}
}
