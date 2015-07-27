package com.emp.mgmt.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "emp_id")
	private long id;
	
	@Column(name = "dept_id")
	private int deptID;
	
	@Column(name = "ename")
	private String empName;

	public void setId(long id) {
		this.id = id;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long getId() {
		return id;
	}

	public int getDeptID() {
		return deptID;
	}

	public String getEmpName() {
		return empName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptID;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (deptID != other.deptID)
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", deptID=" + deptID + ", empName="
				+ empName + "]";
	}
}
