package pro.sky.gots.employees_register.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.gots.employees_register.model.Employee;
import pro.sky.gots.employees_register.service.EmployeesRegisterService;

import java.util.List;

import static pro.sky.gots.employees_register.util.EmployeeGenerator.generateEmployee;

@RestController
@RequestMapping("/employee")
public class EmployeesRegisterController {
    private final static String URL = "http://localhost:8080/employee/";
    private final EmployeesRegisterService employeesRegisterService;

    public EmployeesRegisterController(EmployeesRegisterService employeesRegisterService) {
        this.employeesRegisterService = employeesRegisterService;
    }

    private String getURLForIvanIvanov(String action) {
        String requestIvanIvanov = "?firstName=Ivan&lastName=Ivanov";
        return "<a href=\"" + URL + action + requestIvanIvanov + "\">" +
                URL + action + requestIvanIvanov + "</a><br><br>";
    }
    @GetMapping
    public String welcome() {
        return "<h1 style=\"color:blue; text-align:center\">Welcome to the Register of Employees :)</h1>" +
                "NB: the total number of staff should not exceed " +
                employeesRegisterService.getMaxStaffNumber() +
                ".<hr><br><a href=\"" + URL + "list\"><b>List of employees</b></a><br><br><hr><br>" +
                getURLForIvanIvanov("add")+
                getURLForIvanIvanov("remove")+
                getURLForIvanIvanov("find")+
                "<hr><br>"+
                "<a href=\"" + URL + "createRandomEmployee\">" +
                URL + "/employee/createRandomEmployee</a>";

    }

    @GetMapping("/list")
    public List<Employee> list() {
        return employeesRegisterService.getList();
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName,
                      @RequestParam String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return employeesRegisterService.addEmployee(employee);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName,
                      @RequestParam String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return employeesRegisterService.removeEmployee(employee);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,
                      @RequestParam String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return employeesRegisterService.findEmployee(employee);
    }

    @GetMapping("/createRandomEmployee")
    public Employee createRandomEmployee() {
        Employee employee = generateEmployee();
        return employeesRegisterService.addEmployee(employee);
    }
}
