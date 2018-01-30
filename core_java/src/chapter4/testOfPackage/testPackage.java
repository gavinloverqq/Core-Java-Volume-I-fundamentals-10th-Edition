package chapter4.testOfPackage;

import static java.lang.System.out;
import java.util.*;
import java.sql.*;
import java.util.Date;//上面两个都有Date，避免歧义可在此处增加一个特定的import解决此事，如果两个类都要用，就直接写出包名

public class testPackage {
    public static void publicPrint() {
        out.println("public print");
    }

    private static void privatePrint() {
        out.println("private print");
    }

    static void defaultPrint() {
        out.println("default default print");
    }

    public static void main(String[] args) {
        out.println("static import package");

//        不导入包,直接写全路径
        java.time.LocalDate today = java.time.LocalDate.now();

//
        Date today2;//util 和 sql 都匹配

        publicPrint();
        privatePrint();

        chapter4.testOfPackage.testCompetence.publicPrint();
        chapter4.testOfPackage.testCompetence.defaultPrint();//同一个包里可以使用另一个类未加任何修饰的方法
//        chapter4.testOfPackage.testCompetence.privatePrint();
    }



}
