package chapter4;

import java.time.LocalDate;

public class Employee {
    private String name;//一定要在构造器中初始化，确保构造器执行后必须被设值
    private double salary;
    private LocalDate hireDay;
    private static int nextId = 1;
    private int id = assignId();//使用函数初始化一个域

    public Employee() {

    }

    public Employee(String n, double s, int year, int month, int day) {
        this();//调用上面的构造器，实现一个构造器中调用另一个构造器
        name = n;
        salary = s;
//        double salary = s; //不能在构造器中定义重名局部变量，例如这个语句是无法设置salary的
        hireDay = LocalDate.of(year, month, day);
    }

//    静态初始化块
    static {
        System.out.println("static initialization block");
    }

    private static int assignId() {
        int r = nextId;
        nextId++;
        return r;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
