package chapter4;

import java.time.LocalDate;

class Employee {
    private final String name;//一定要在构造器中初始化，确保构造器执行后必须被设值
    private double salary;
    private LocalDate hireDay;

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
//        double salary = s; //不能在构造器中定义重名局部变量，例如这个语句是无法设置salary的
        hireDay = LocalDate.of(year, month, day);
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
