package com.csi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import com.csi.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

	@Override
	public void saveData(Employee employee) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
	}

	@Override
	public void saveAllData(List<Employee> employee) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		for (Employee e : employee) {
			session.save(e);
		}
		transaction.commit();
	}

	@Override
	public Employee getDataById(int empId, Employee employee) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> empList = session.createQuery("from Employee").list();
		for (Employee e : empList) {
			if (e.getEmpId() == empId) {
				employee.setEmpId(e.getEmpId());
				employee.setEmpName(e.getEmpName());
				employee.setEmpSalary(e.getEmpSalary());
				employee.setEmpJoinDate(e.getEmpJoinDate());
				transaction.commit();
			}
		}
		return employee;
	}

	@Override
	public List<Employee> getAllData() {
		Session session = factory.openSession();
		List<Employee> empList = session.createQuery("from Employee").list();
		return empList;
	}

	@Override
	public void updateData(int empId, Employee employee) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> empList = session.createQuery("from Employee").list();
		for (Employee e : empList) {
			if (e.getEmpId() == empId) {
				employee.setEmpName(e.getEmpName());
				employee.setEmpSalary(e.getEmpSalary());
				employee.setEmpJoinDate(e.getEmpJoinDate());
				session.update(e);
			}
		}
		transaction.commit();
	}

	@Override
	public void deleteDataById(int empId) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> empList = session.createQuery("from Employee").list();
		for (Employee e : empList) {
			if (e.getEmpId() == empId) {
				session.delete(e);
				transaction.commit();
			}
		}
	}

	@Override
	public void deleteAllData() {
		Session session = factory.openSession();
		List<Employee> empList = session.createQuery("from Employee").list();
		for (Employee e : empList) {
			Transaction transaction = session.beginTransaction();
			session.delete(e);
			transaction.commit();
		}
	}
}
