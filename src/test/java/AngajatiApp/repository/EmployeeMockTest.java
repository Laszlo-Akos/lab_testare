package AngajatiApp.repository;

import static AngajatiApp.controller.DidacticFunction.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import AngajatiApp.repository.EmployeeMock;

public class EmployeeMockTest {

    private EmployeeMock employeeMock;

    @BeforeEach
    public void setUp() {
        employeeMock = new EmployeeMock();
    }

    @Test
    public void testAddEmployee_ValidCnp() {
        Employee employee = new Employee("Ioan", "Popescu", "1234567890123", TEACHER, 3000.00);

        boolean result = employeeMock.addEmployee(employee);
        assertTrue(result);
        assertEquals(3, employeeMock.getEmployeeList().size());
    }

    @Test
    public void testAddEmployee_InvalidCnp() {
        Employee employee = new Employee("Ioan", "Popescu", "12", TEACHER, 3000.00);

        boolean result = employeeMock.addEmployee(employee);
        assertFalse(result);
        assertEquals(2, employeeMock.getEmployeeList().size());
    }

    @Test
    public void testAddEmployee_ValidLastName_NoSpecialCharacters() {
        Employee employee = new Employee("Ioan", "Popescu", "1234567890123", TEACHER, 3000.00);

        boolean result = employeeMock.addEmployee(employee);
        assertTrue(result);
        assertEquals(3, employeeMock.getEmployeeList().size());
    }

    @Test
    public void testAddEmployee_InvalidLastName_WithSpecialCharacters() {
        Employee employee = new Employee("Ioan", "Pop@78", "1234567890123", TEACHER, 3000.00);

        boolean result = employeeMock.addEmployee(employee);
        assertFalse(result);
        assertEquals(2, employeeMock.getEmployeeList().size());
    }






}
