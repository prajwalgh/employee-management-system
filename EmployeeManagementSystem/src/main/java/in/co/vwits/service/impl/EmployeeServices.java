package in.co.vwits.service.impl;

import java.util.List;
import java.util.Optional;

import in.co.vwits.dao.ems.model.Employee;
import in.co.vwits.model.exception.EmployeeNotFoundException;

public interface EmployeeServices {
		List<Employee> findAllStudentSortedBySalary();

		List<Employee> findAll();

		void save(Employee s);
		Optional<Employee> findByEmpId(int empid) throws EmployeeNotFoundException;


		void deleteByEmpId(int empid);

		void updateByEmpId(int empid, double modifiedSalary);
}
