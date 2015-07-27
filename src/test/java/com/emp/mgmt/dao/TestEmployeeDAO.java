package com.emp.mgmt.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emp.mgmt.persistence.Employee;

/**
 * 
 * @author Priya Maheshwari
 * 
 *         These are Integration test cases which test the DAO layer by making
 *         actual updates in DB
 * 
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring/application-context.xml")
public class TestEmployeeDAO {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private EmployeeDAO empDao;

	@Test
	public void testSaveEmployee() throws Exception {
		Employee employee = new Employee();
		employee.setDeptID(1);
		employee.setEmpName("Priya");
		empDao.addEmployee(employee);
	}

	@Test
	public void testGetEmployee() throws Exception {
		Employee employee = empDao.getEmployeeByID(5L);
		System.out.println("employee=" + employee);
	}

	@Test
	public void testUpdateEmployee() throws Exception {
		Employee employee = new Employee();
		employee = empDao.getEmployeeByID(5L);
		if (employee.getId() == 5) {
			employee.setDeptID(5);
		}
		empDao.updateEmployee(employee);
	}

	@Test
	public void testDeleteEmployee() throws Exception {
		empDao.deleteEmployee(5);
	}
}
