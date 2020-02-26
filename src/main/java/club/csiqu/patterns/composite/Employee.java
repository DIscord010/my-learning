package club.csiqu.patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/8/7 16:25
 */
public class Employee {

    private String name;

    private String dept;

    private int salary;

    private List<Employee> subordinates;

    Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.subordinates = new ArrayList<>();
    }

    void add(Employee employee) {
        subordinates.add(employee);
    }

    List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}