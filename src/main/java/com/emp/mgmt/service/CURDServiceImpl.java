package com.emp.mgmt.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.emp.mgmt.persistence.Employee;
import com.emp.mgmt.persistence.Role;
import com.emp.mgmt.utility.HibernateUtil;

public class CURDServiceImpl {
	public static void main(String[] aa) {
		CURDServiceImpl curdServiceImpl = new CURDServiceImpl();
		curdServiceImpl.saveEmployee("Priya", 1);
		curdServiceImpl.saveEmployee("ABC", 2);
		curdServiceImpl.saveEmployee("DEF", 3);

	}

	public void saveEmployee(String ename, int deptID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Employee emp = new Employee();
			emp.setDeptID(deptID);
			emp.setEmpName(ename);
			session.save(emp);
			transaction.commit();
			System.out.println("Record inserted successfully");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void updateEmployee() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String queryStr = "from emp where emp_id = :empID";
			Query query = session.createQuery(queryStr);
			query.setString("ename", "Priya");
			Employee emp = (Employee) query.uniqueResult();
			emp.setEmpName("Nerd");
			session.update(emp);
			System.out.println("Record updated successfully");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void deleteEmployee() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String quertStr = "from emp where emp_id = empID";
			Query query = session.createQuery(quertStr);
			query.setInteger("empID", 1);
			Employee emp = (Employee) query.uniqueResult();
			session.delete(emp);
			System.out.println("Record deleted successfully");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void retriveEmployee() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List employee = session.createQuery("from emp").list();
			for (Iterator iterator = employee.iterator(); iterator.hasNext();) {
				Employee employee1 = (Employee) iterator.next();
				System.out.println(employee1.getId() + "  " + employee1.getEmpName() + "   " + employee1.getDeptID());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void saveRole(int deptID, String dName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Role role = new Role();
			role.setId(deptID);
			role.setName(dName);
			session.save(role);
			transaction.commit();
			System.out.println("Role inserted successfully");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("null")
	public void update() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction.begin();
			String queryStr = "from role where dept_id = deptID";
			Query query = session.createQuery(queryStr);
			query.setInteger("deptID", 2);
			Role role = (Role) query.uniqueResult();
			role.setId(8);
			session.update(role);
			System.out.println("Dept ID updated successfully");
		} catch (HibernateException e) {
			transaction.rollback();
			System.out.println("No record found");
		} finally {
			session.close();
		}
	}

	public void delete() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction.begin();
			String queryStr = "from role where dept_id = deptID";
			Query query = session.createQuery(queryStr);
			query.setInteger("deptID", 1);
			Role role = (Role) query.uniqueResult();
			session.delete(role);
			System.out.println("Department record deleted successfully");
		} catch (HibernateException e) {
			transaction.rollback();
			System.out.println("No record found");
		} finally {
			session.close();
		}

	}

}
