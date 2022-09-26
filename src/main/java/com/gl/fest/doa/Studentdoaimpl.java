package com.gl.fest.doa;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gl.fest.model.Student;

@Repository
public class Studentdoaimpl implements Studentdoa {
	
	@Autowired
	SessionFactory factory ;
	
   @Transactional
	public void savestudent(Student student) {
	 
	Session session = factory.getCurrentSession();
	session.saveOrUpdate(student);

	}

   @Transactional
	public void deletestudent(int id) {
	   Session session = factory.getCurrentSession();
	 Student s = session.get(Student.class, id);
	 session.delete(s);
	}

   @Transactional
	public Student findbyid(int id) {
	   Session session = factory.getCurrentSession();
	   return session.get(Student.class, id);
	}

   @Transactional
	public List<Student> listall() {
	   Session session = factory.getCurrentSession();
	   Query query = session.createQuery("from Student");
		return query.getResultList();
	}

@Override
public List<Student> search(String name, String department) {
	Session session = factory.getCurrentSession();
	Criteria c = session.createCriteria(Student.class);
	Criterion n = Restrictions.eq("name", name);
	Criterion d = Restrictions.eq("department", department);
	Criterion combine = Restrictions.and(n, d);
	c.add(combine);
	return c.list();
	
}

}
