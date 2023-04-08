package pro.sky.gots.employees_register.service;


import org.springframework.stereotype.Service;
import pro.sky.gots.employees_register.exceptions.EmployeeAlreadyAddedException;
import pro.sky.gots.employees_register.exceptions.EmployeeNotFoundException;
import pro.sky.gots.employees_register.exceptions.EmployeeStorageIsFullException;
import pro.sky.gots.employees_register.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeRegisterServiceImpl implements EmployeesRegisterService {

    private final static int MAX_EMPLOYEES_COUNT = 3;
    private final List<Employee> employees = new ArrayList<>(MAX_EMPLOYEES_COUNT);

    @Override
    public int getMaxStaffNumber() {
        return MAX_EMPLOYEES_COUNT;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        int index = employees.indexOf(employee);
        if (index != -1) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() == MAX_EMPLOYEES_COUNT) {
            throw new EmployeeStorageIsFullException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(Employee employeeToRemove) {
        int index = indexOfEmployee(employeeToRemove);
        Employee employee = employees.get(index);
        employees.remove(index);
        return employee;
    }

    @Override
    public Employee findEmployee(Employee employee) {
        int index = indexOfEmployee(employee);
        return employees.get(index);
    }

    private int indexOfEmployee(Employee employee) {
        int index = employees.indexOf(employee);
        if (index == -1) {
            throw new EmployeeNotFoundException();
        }
        return index;
    }

    @Override
    public List<Employee> getList() {
        return new ArrayList<>(employees);
    }
}
