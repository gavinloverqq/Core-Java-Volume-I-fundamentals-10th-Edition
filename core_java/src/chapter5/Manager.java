package chapter5;
import chapter4.Employee;

public class Manager extends Employee{
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);//super 调用构造其的语句必须放在第一句，如果没有显式的调用超类的构造器将调用超类默认的没有参数的构造器，如果超类没有则报错
        bonus = 0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public static void main(String[] args) {
        Manager boss = new Manager("Sb1", 8000, 2000, 1, 1);
        boss.setBonus(500);

        Employee[] staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("Sb2", 4000, 2000, 1, 2);
        staff[2] = new Employee("Sb3", 3000, 2000, 1, 4);

        for (Employee e : staff) {
            System.out.println(e.getName() + " " + e.getSalary());
        }

    }
}
