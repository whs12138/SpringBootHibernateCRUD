package com.csi.service;

import java.util.List;

import com.csi.model.Employee;

public interface EmployeeService {

	public void saveData(Employee employee);

	public void saveAllData(List<Employee> employee);

	public Employee getDataById(int empId, Employee employee);

	public List<Employee> getAllData();

	public void updateData(int empId, Employee employee);

	public void deleteDataById(int empId);

	public void deleteAllData();

}
