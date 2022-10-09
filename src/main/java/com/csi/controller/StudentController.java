package com.csi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/saveData")
	public String saveData(@RequestBody Employee employee) {
		employeeService.saveData(employee);
		return "Data Save";
	}

	@PostMapping("/saveAllData")
	public String saveAllData(@RequestBody List<Employee> employee) {
		employeeService.saveAllData(employee);
		return "All Data Save";
	}

	@GetMapping("/getDataById/{empId}")
	public Employee getDataById(@PathVariable("empId") int empId, Employee employee) {
		return employeeService.getDataById(empId, employee);
	}

	@GetMapping("/getAllData")
	public List<Employee> getAllData() {
		return employeeService.getAllData();
	}

	@PutMapping("updateData/{empId}")
	public String updateData(@PathVariable("empId") int empId, @RequestBody Employee employee) {
		employeeService.updateData(empId, employee);
		return "Data Updated ";
	}

	@DeleteMapping("/deleteDataById/{empId}")
	public String deleteDataById(@PathVariable("empId") int empId) {
		employeeService.deleteDataById(empId);
		return "Data Removed";
	}

	@DeleteMapping("/deleteAllData")
	public String deleteAllData() {
		employeeService.deleteAllData();
		return "Empty";
	}
}
