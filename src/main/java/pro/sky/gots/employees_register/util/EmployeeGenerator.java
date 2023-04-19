package pro.sky.gots.employees_register.util;

import pro.sky.gots.employees_register.model.Employee;

import java.util.Random;

public final class EmployeeGenerator {

    public static final Random random = new Random();
    public static final String[] firstNames = {"Ivan", "Petr", "Pavel"};
    public static final String[] lastNames = {"Ivanov", "Petrov", "Sidorov"};

    public static Employee generateEmployee() {
        return  new Employee(firstNames[random.nextInt(firstNames.length)],
                lastNames[random.nextInt(lastNames.length)]);
    }

}
