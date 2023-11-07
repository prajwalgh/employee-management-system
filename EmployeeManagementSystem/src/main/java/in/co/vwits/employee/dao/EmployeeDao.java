package in.co.vwits.employee.dao;

import java.util.List;
import java.util.Optional;

import in.co.vwits.dao.ems.model.Employee;

public interface EmployeeDao {
	public int save(Employee s);
	public Optional<Employee> findByEmpId(int rollno);
	public List<Employee> findAll();
	public void deleteByEmpId(int rollno);
	  public void updateByEmpId(int rollno, double modifiedMarks);

}