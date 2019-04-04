package de.fhws.Aufgabe13;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;

class DepartmentTest {
	Department itDepartment;
	
	@Test
	void checkUniqueIdent() {
		createDepartment();
		UUID tmp = itDepartment.getSupervisor().getIdent();
		Employee[] employees = itDepartment.getEmployees();
		
		for (int i = 0; i < employees.length; i++) {
			assertFalse(tmp.toString().equals(employees[i].getIdent().toString()));
			tmp = employees[i].getIdent();
		}
	}
	
	@Test
	void checkEmployeeDefaultSalary() {
		createDepartment();	
		checkSalary(30000d, itDepartment.getEmployees()[0]);
	}
	
	@Test
	void checkSupervisorDefaultSalary() {
		createDepartment();
		checkSalary(130000d, itDepartment.getSupervisor());
	}
	
	@Test
	
	void checkPromoteMethod() {
		createDepartment();
		Employee employee = itDepartment.getEmployees()[0];
		Supervisor supervisor = itDepartment.getSupervisor();
		
		checkSalary(30000d, employee);
		supervisor.promote(employee);
		checkSalary(33000d, employee);
		supervisor.promote(employee);
		checkSalary(36300d, employee);
		
	}
	
	void checkSalary(double salary, Employee employee) {
		assertEquals(salary, employee.getSalary(), 0.00001);
	}
	
	void createDepartment() {
		Supervisor sv = new Supervisor("Max", "Muster", 65000d, "01.01.1999");
		
		Employee[] employees = {
				new Employee("Otto", "Totto", 30000d, "04.05.1953"),	
				new Employee("Karl", "Bodo", 40000d, "26.10.1973"),	
		};
		
		itDepartment = new Department(employees, sv);
	}

}
