/**
 * 
 */
package com.emp.mgmt.services;

import org.easymock.EasyMock;
import org.easymock.Mock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.emp.mgmt.dao.EmployeeDAO;
import com.emp.mgmt.persistence.Employee;

/**
 * @author Priya Maheshwari
 * 
 *         These are JUnit test cases which mock test only EmployeeServiceImpl
 *         class by mocking the actual DAO calls made in that class
 */
public class TestEmployeeService {
	private EmployeeServiceImpl empService;

	@Mock
	private EmployeeDAO empDao;

	@Before
	public void setup() {
		empDao = EasyMock.createNiceMock(EmployeeDAO.class);
		empService = new EmployeeServiceImpl();
	}

	@Test
	public void testAddEmployee() throws Exception {
		Employee employee = mockEmployee();
		EasyMock.expect(empDao.addEmployee(employee)).andReturn(true)
				.anyTimes();
		setupEmpDao();
		boolean isAdded = empService.addEmployee(employee);
		Assert.assertTrue(isAdded);
	}

	@Test
	public void testUpdateEmployee() throws Exception {
		Employee employee = mockEmployee();
		employee.setEmpName("XYZ");
		EasyMock.expect(empDao.updateEmployee(employee)).andReturn(true)
				.anyTimes();
		setupEmpDao();
		boolean isAdded = empService.updateEmployee(employee);
		Assert.assertTrue(isAdded);
	}

	@Test
	public void testGetEmployee() throws Exception {
		EasyMock.expect(empDao.getEmployeeByID(1L)).andReturn(mockEmployee())
				.anyTimes();
		setupEmpDao();
		Employee employee = empService.getEmployeeByID(1L);
		Assert.assertTrue(employee != null);
	}

	@Test
	public void testDeleteEmployee() throws Exception {
		EasyMock.expect(empDao.deleteEmployee(1L)).andReturn(true).anyTimes();
		setupEmpDao();
		boolean isDeleted = empService.deleteEmployee(1L);
		Assert.assertTrue(isDeleted);
	}

	private void setupEmpDao() {
		EasyMock.replay(empDao);
		empService.setEmpDao(empDao);
	}

	private Employee mockEmployee() {
		Employee employee = new Employee();
		employee.setDeptID(3);
		employee.setEmpName("ABCD");
		return employee;
	}
}
