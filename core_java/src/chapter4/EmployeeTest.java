package chapter4;

import java.util.Collections;

public class EmployeeTest {

    public static void tripleSalary(Employee e) {
        e.raiseSalary(200);
    }

    public static void swap(Employee x, Employee y) {
        Employee t = x;
        x = y;
        y = t;
    }

//    TODO
    public static void realSwap(Employee x, Employee y) {

    }

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("tony", 1000, 1999, 12 ,15);
        staff[1] = new Employee("tom", 1200, 1998, 10 ,14);
        staff[2] = new Employee("bob", 1300, 1997, 11 ,12);

        for (Employee e : staff) {
            e.raiseSalary(5);
        }

        for (Employee e : staff) {
            System.out.printf("name = %s, salary = %.2f\n", e.getName(), e.getSalary());
        }

        Employee e = new Employee("sb", 1000, 1000, 10,10);
        System.out.printf("before: name = %s, salary = %.2f\n", e.getName(), e.getSalary());
        tripleSalary(e);
        System.out.printf("after: name = %s, salary = %.2f\n", e.getName(), e.getSalary());

        System.out.println("*********************************");
        Employee e2 = new Employee("sb2", 2000, 2000, 12,20);
        System.out.printf("before: name = %s, id = %d, salary = %.2f\n", e2.getName(), e2.getId(), e2.getSalary());
        System.out.printf("before: name = %s, id = %d, salary = %.2f\n", e.getName(), e.getId(), e.getSalary());
        swap(e, e2);
        System.out.printf("after: name = %s, salary = %.2f\n", e2.getName(), e2.getSalary());
        System.out.printf("after: name = %s, salary = %.2f\n", e.getName(), e.getSalary());



    }
}
