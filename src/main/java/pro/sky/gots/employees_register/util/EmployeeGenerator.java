package pro.sky.gots.employees_register.util;

import pro.sky.gots.employees_register.model.Employee;

import java.util.Random;
/** Static method for genearating Employee instance 
 *  with randomly choosen first and last names.
 *
 **/
public final class EmployeeGenerator {
    /** static Random instance, could be available outside the class **/
    public static final Random random = new Random();
    /** Array, first names set **/
    private static final String[] firstNames = {"Ivan", "Petr", "Pavel"};
    /** Array, last names set **/
    private static final String[] lastNames = {"Ivanov", "Petrov", "Sidorov"};
    /** @return an Employee instance initiated with randomly choosen first and last names .
     *
     **/
    public static Employee generateEmployee() {
        return  new Employee(firstNames[random.nextInt(firstNames.length)],
                lastNames[random.nextInt(lastNames.length)]);
    }

}
