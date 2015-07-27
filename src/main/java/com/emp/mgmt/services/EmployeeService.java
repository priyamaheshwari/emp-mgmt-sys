package com.emp.mgmt.services;

import com.emp.mgmt.persistence.Employee;

public interface EmployeeService {
	public boolean addEmployee(Employee employee)throws Exception;
	public Employee getEmployeeByID(long id)throws Exception;
	public boolean deleteEmployee(long id)throws Exception;
	public boolean updateEmployee(Employee employee)throws Exception;
}
