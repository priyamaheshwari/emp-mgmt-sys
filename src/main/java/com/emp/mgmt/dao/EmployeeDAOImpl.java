package com.emp.mgmt.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.emp.mgmt.persistence.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addEmployee(Employee employee) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
		session.close();
		System.out.println("Employee record inserted successfully");
		return true;

	}

	public Employee getEmployeeByID(long id) throws Exception {
		Session session = sessionFactory.openSession();
		Employee employee = (Employee) session.load(Employee.class, id);
		session.close();
		return employee;
	}

	public boolean updateEmployee(Employee employee) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(employee);
		transaction.commit();
		System.out.println("Employee record updated successfully");
		session.close();
		return true;
	}

	public boolean deleteEmployee(long id) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Object obj = session.load(Employee.class, id);
		session.delete(obj);
		transaction.commit();
		System.out.println("Employee record delete");
		System.out
				.println("Employee record not deleted . May be no record / employee ID is wrong");
		session.close();
		return true;
	}

}
