package de.fhws.Aufgabe13;

public class Department {
	private Employee[] employees;
	private Supervisor supervisor;

	public Department() {}
	
	public Department(Employee[] employees, Supervisor supervisor) {
		this.employees = employees;
		this.supervisor = supervisor;
	}

	public Employee[] getEmployees() {
		return employees;
	}

	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}
}
