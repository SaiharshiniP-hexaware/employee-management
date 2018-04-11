package com.hexa.dao;

import java.util.List;

import com.hexa.entity.Dept;
import com.hexa.entity.Emp;

public interface EmpDao {
	List<Dept> getDepartments();
	List<Emp> getEmployees();
	List<Emp> getEmployees(int did);
	Emp getEmployee(int eid) throws NotFoundException;
	int addEmployee(Emp emp) throws IdException;
}
