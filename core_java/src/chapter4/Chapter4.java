package chapter4;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Chapter4 {
    static void test0() {
        Date date;//date 只是一个变量
//        System.out.println(date.toString());//Error:(9, 28) java: variable date might not have been initialized
        date = new Date(); // new Date()是一个对象，绑定到date上
        System.out.println(date.toString());
        date = null;
//        System.out.println(date.toString());//将date设置成null
    }

    static void test1() {
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.of(1999,9,1));
    }

    static void test2() {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        for (int i = 1; i < value; i++) {
            System.out.println(" ");
        }

        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (today == date.getDayOfMonth()) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
        if (date.getDayOfWeek().getValue() == 1) {
            System.out.println();
        }
    }




    public static void main(String[] args) {
        test0();
        test1();
        test2();
    }
}
