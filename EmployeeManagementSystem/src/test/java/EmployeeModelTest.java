//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//import in.co.vwits.dao.ems.model.Employee;
//import in.co.vwits.ems.dao.impl.EmployeeDaoImpl;
//
//
//
//public class EmployeeTest {
//	private EmployeeDaoImpl obj;
//	@BeforeEach
//	public void SetUp() {
//		System.out.println("run before each ");
//		obj=new EmployeeDaoImpl();
//	}
//	@AfterEach
//	public void TearDown() {
//		System.out.println("run after each ");
//	}
//	@Test
//	public void saveShouldSaveData() {
//		System.out.println("saveShouldSaveData");
//		Employee obj1= new Employee();
//		obj1.setId(4);
//		obj1.setName("oj");
//		obj1.setSalary(2312);
//		obj.save(obj1);
//		Employee emp=obj.findById(4).orElse(null);
//		assertNotNull(emp);
//		// Assert that the saved employee's properties match the expected values
//        assertEquals(obj1.getId(), emp.getId());
//        assertEquals(obj1.getName(), emp.getName());
//        assertEquals(obj1.getSalary(), emp.getSalary());
//	}
//	@Test
//    public void findAllShouldReturnAllData() {
//        // Call the findAll method to retrieve all employees
//        List<Employee> allEmployees = obj.findAll();
//
//        // You should assert something about the result
//        // For example, you can assert that the size of the list matches the expected size
//        int expectedSize = allEmployees.size();
//        assertEquals(expectedSize, allEmployees.size());
//    }
//
//	@ParameterizedTest()
//	@CsvSource({"1"})
//	public void findByIdShouldReturnEmpWithId(int id) {
//		Optional<Employee> actual=obj.findById(id);
//		assertTrue(actual.isPresent());
//		Employee empl=actual.get();
//		assertEquals(id,empl.getId());
//	}
//	@ParameterizedTest()
//	@CsvSource({"1","2"})
//	public void deleteByIdShouldDeleteempWithId(int id) {
//		assertTrue(obj.findById(id).isPresent());
//		obj.deleteById(id);
//		assertFalse(obj.findById(id).isPresent());
//	}
//	@ParameterizedTest()
//	@CsvSource({"1,2000","2,4000"})
//	public void updateById(int id, int sal) {
//		// Update the salary of the employee with the specified ID
//        obj.updateById(id, sal);
//
//        // Retrieve the updated employee's salary
//        Employee updatedEmployee = obj.findById(id).orElse(null);
//
//        // Assert that the updated employee exists and has the expected salary
//        assertEquals(sal, updatedEmployee.getSalary());
//	}
//}
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import in.co.vwits.dao.ems.model.Employee;
import in.co.vwits.ems.dao.impl.EmployeeDaoImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.Optional;

public class EmployeeModelTest {
    private EmployeeDaoImpl obj;

    @BeforeEach
    public void setUp() {
        obj = new EmployeeDaoImpl();
    }

    @Test
    public void saveShouldSaveData() {
        Employee obj1 = new Employee();
        obj1.setId(4);
        obj1.setName("oj");
        obj1.setSalary(2312);
        obj.save(obj1);
        Employee emp = obj.findById(4).orElse(null);
        assertNotNull(emp);
        assertEquals(obj1.getId(), emp.getId());
        assertEquals(obj1.getName(), emp.getName());
        assertEquals(obj1.getSalary(), emp.getSalary());
    }

    @Test
    public void findAllShouldReturnAllData() {
        List<Employee> allEmployees = obj.findAll();
        int expectedSize = 3; // Adjust the expected size based on the data you initialize
        assertEquals(expectedSize, allEmployees.size());
    }

    @ParameterizedTest()
    @CsvSource({"1"})
    public void findByIdShouldReturnEmpWithId(int id) {
        Optional<Employee> actual = obj.findById(id);
        assertTrue(actual.isPresent());
        Employee empl = actual.get();
        assertEquals(id, empl.getId());
    }

    @ParameterizedTest()
    @CsvSource({"1", "2"})
    public void deleteByIdShouldDeleteEmpWithId(int id) {
        assertTrue(obj.findById(id).isPresent());
        obj.deleteById(id);
        assertFalse(obj.findById(id).isPresent());
    }

    @ParameterizedTest()
    @CsvSource({"1,2000", "2,4000"})
    public void updateById(int id, int sal) {
        obj.updateById(id, sal);
        Employee updatedEmployee = obj.findById(id).orElse(null);
        assertNotNull(updatedEmployee);
        assertEquals(sal, updatedEmployee.getSalary());
    }
}
