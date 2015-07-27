/**
 * 
 */
package com.emp.mgmt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emp.mgmt.persistence.Employee;
import com.emp.mgmt.services.EmployeeService;

/**
 * @author Priya Maheshwari
 * 
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addEmployee(@RequestBody Employee employee) {
		Status status = new Status();
		try {
			empService.addEmployee(employee);
			status.setCode(200);
			status.setMessage("Employee successfully added");
		} catch (Exception e) {
			status.setCode(500);
			status.setMessage("Unknown error occurred:" + e);
		}
		return status;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Employee getEmployee(@PathVariable("id") long id) {
		Employee employee = null;
		try {
			employee = empService.getEmployeeByID(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
}
