package pro.sky.gots.employees_register.model;

import java.util.Objects;

/**
 * Class Employee, который содержит имя и фамилию сотрудника.
 **/
public class Employee {
    private static int nextId;
    private final int id;
    private final String firstName;
    private final String lastName;

    public Employee(String firstName, String lastName) {
        id = ++nextId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastNameName() {   return lastName;    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
