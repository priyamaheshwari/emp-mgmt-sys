package com.emp.mgmt.persistence;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private long empID;
	private int deptID;
	private String empName;

	public void setEmpID(long empID) {
		this.empID = empID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long getEmpID() {
		return empID;
	}

	public int getDeptID() {
		return deptID;
	}

	public String getEmpName() {
		return empName;
	}
}
