package com.emp.mgmt.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.emp.mgmt.dao.EmployeeDAO;
import com.emp.mgmt.persistence.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDAO empDao;
	
	public boolean addEmployee(Employee employee) throws Exception {
		return empDao.addEmployee(employee);
	}

	public Employee getEmployeeByID(long id) throws Exception {
		return empDao.getEmployeeByID(id);
	}

	public boolean deleteEmployee(long id) throws Exception {
		return empDao.deleteEmployee(id);
	}

	public boolean updateEmployee(Employee employee) throws Exception {
		return empDao.updateEmployee(employee);
	}

	public void setEmpDao(EmployeeDAO empDao) {
		this.empDao = empDao;
	}

}
