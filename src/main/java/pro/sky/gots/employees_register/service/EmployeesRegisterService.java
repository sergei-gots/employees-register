package pro.sky.gots.employees_register.service;

import pro.sky.gots.employees_register.model.Employee;

import java.util.List;

public interface EmployeesRegisterService {

    Employee addEmployee(Employee employee);

    Employee removeEmployee(Employee employee);

    Employee findEmployee(Employee employee);

    int getMaxStaffNumber();

    List<Employee> getList();
}
