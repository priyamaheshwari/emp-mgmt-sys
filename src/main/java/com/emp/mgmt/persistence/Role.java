package com.emp.mgmt.persistence;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	private int deptID;
	private String deptName;

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getDeptID() {
		return deptID;
	}

	public String getDeptName() {
		return deptName;
	}
}
