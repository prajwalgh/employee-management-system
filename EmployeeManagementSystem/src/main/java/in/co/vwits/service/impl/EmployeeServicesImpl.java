
package in.co.vwits.service.impl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import in.co.vwits.dao.ems.model.Employee;
import in.co.vwits.ems.dao.impl.EmployeeDaoImpl;
import in.co.vwits.model.exception.EmployeeNotFoundException;

public class EmployeeServicesImpl implements EmployeeServices {
	
	private EmployeeDaoImpl dao;
	public EmployeeServicesImpl(){
		dao= new EmployeeDaoImpl();

	}	

	//Using Sorted
	@Override
	public List<Employee> findAllStudentSortedBySalary(){
		return dao.findAll().stream().sorted().collect(Collectors.toList()); 
	}

	@Override
	public List<Employee> findAll(){
		return dao.findAll();
	}
	@Override
	public void save(Employee s) {
		dao.save(s);
	}
	//Find Case 3
	public Optional<Employee> findByEmpId(int EmpId) throws EmployeeNotFoundException {
		Optional<Employee> p=dao.findById(EmpId);
		if(p.isPresent()) {
			return p;
		}
		else {
			// throw user defined exception "StudentNotFound"
			throw new EmployeeNotFoundException();
		}

	}
	@Override
	public void deleteByEmpId(int rollno) {
		dao.deleteById(rollno);

	}
	
	  @Override
	public void updateByEmpId(int rollno, double modifiedMarks) {
	  dao.updateById(rollno,modifiedMarks); }

}
