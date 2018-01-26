package chapter4;

public class EmployeeTest {
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
    }
}
