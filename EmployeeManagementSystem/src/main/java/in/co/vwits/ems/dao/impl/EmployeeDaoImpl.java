package in.co.vwits.ems.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import in.co.vwits.dao.ems.model.Employee;

//TODO first we will try to implement it in primary memory then we will implement it in database using jdbc.
public class EmployeeDaoImpl  {
		/**
		 * this is were we will store each employee detail
		 */
		private List<Employee> empLst;
		
		/**
		 * constructor to create few emp and add them to emp
		 */
		public EmployeeDaoImpl() {
			empLst = new ArrayList<>();
			Employee obj1= new Employee();
			obj1.setId(1);
			obj1.setName("Ashok");
			obj1.setSalary(80000);
			Employee obj2= new Employee();
			obj2.setId(2);
			obj2.setName("Bhavesh");
			obj2.setSalary(3000);
			Employee obj3= new Employee();
			obj3.setId(3);
			obj3.setName("Chetan");
			obj3.setSalary(9700);
			empLst.add(obj1);
			empLst.add(obj2);
			empLst.add(obj3);
		}
		public List<Employee> findAll() {
			//return null;
			return empLst;
		}
		public void save(Employee e) {
			empLst.add(e);
		}
		public Optional<Employee> findById(int id){
			//return null;
			Employee empfound=empLst.stream().filter(s->s.getId() == id).findFirst().orElse(null);
			return Optional.ofNullable(empfound);
		}
		public void deleteById(int id) {
			empLst.removeIf(employee->employee.getId() == id);
		}
		public void updateById(int id, double sal) {
		    Optional<Employee> employeeToUpdate = empLst.stream()
		            .filter(emp -> emp.getId() == id)
		            .findFirst();

		    employeeToUpdate.ifPresent(employee -> {
		        employee.setSalary(sal);
		    });
		}
}
