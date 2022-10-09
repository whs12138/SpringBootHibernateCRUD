package com.csi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDaoImpl;

	@Override
	public void saveData(Employee employee) {
		employeeDaoImpl.saveData(employee);
	}

	@Override
	public void saveAllData(List<Employee> employee) {
		employeeDaoImpl.saveAllData(employee);
	}

	@Override
	public Employee getDataById(int empId, Employee employee) {
		return employeeDaoImpl.getDataById(empId, employee);
	}

	@Override
	public List<Employee> getAllData() {
		return employeeDaoImpl.getAllData();
	}

	@Override
	public void updateData(int empId, Employee employee) {
		employeeDaoImpl.updateData(empId, employee);
	}

	@Override
	public void deleteDataById(int empId) {
		employeeDaoImpl.deleteDataById(empId);
	}

	@Override
	public void deleteAllData() {
		employeeDaoImpl.deleteAllData();
	}

}
