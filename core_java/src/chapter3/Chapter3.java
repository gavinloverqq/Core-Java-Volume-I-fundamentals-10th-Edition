package chapter3;

import kotlin.io.ConsoleKt;
import kotlin.io.FileSystemException;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.*;

/**
 * Created by wankun on 2018/1/5.
 */
public class Chapter3 {
    void test1() {
        int x;
//        与C++不同，java的 x = 0返回值是int形，无法转换成boolean
//        if (x = 0) {
//            System.out.print("true");
//        }
    }

//    java不区分定义和声明
    void test2() {
        int x;
//        System.out.print(x);//java 编译器认为未初始化的语句是错的
    }

    private static void test3() {//????为啥要加private static？？
        final double PI = 3.14;
        System.out.println(PI);
    }

    private static void test4() {
        int x = 2, y = 15;
        double z = 11.1;
        System.out.println(y / x);
        System.out.println(z / x);
        System.out.println(1.0 / 3.0 * 3.0);
    }

//    java 计算过程中使用精确计算，而不是截断中间结果，需要加strictfp关键字
    private static strictfp void test5() {
        double a = 1.0, b = 3.0, c = 2.0;
        System.out.println(a / b * 3);
        double sq = Math.sqrt(b);
        double pw = Math.pow(c, b);
        System.out.println(sq);
        System.out.println(pw);
        int fm = Math.floorMod(3, -2);//负除数  -1
        int fm1 = 3 % -2;//负除数  1
        int fm2 = Math.floorMod(-3, 2);//除数  1// 针对除法，floorMod总能得到正数
        int fm3 = -3 % 2;//除数  -1
        System.out.println(fm + " " + fm1 + " " + fm2 + " " + fm3);

        System.out.println(sqrt(PI));// 静态倒入了Math包
    }

    private static void test6() {
        double a = 9.997;
        int nx = (int)a;
        System.out.println(nx); // 9 去尾取整
        double b = 9.997;
        int ny = (int)Math.round(b); // 10 四舍五入
        System.out.println(ny);
    }

//    boolean和int不能转换
    private static void test7() {
        int a = 10;
//        if (a) { // int 不能转换成boolean
//            System.out.println("true");
//        } else {
//            System.out.println("true");
//        }

        boolean b = true;
        if (b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        int c = b ? 1 : 0;//boolean 转换成int
        System.out.println(c);
    }

//    移位操作
    private static void test8() {
        int a = 1;
        int b = -16;
        int c = -16;
        System.out.println(a << 30);
        System.out.println(a << 35);//右移要模32   等价于  1 << 3  = 8
        System.out.println(b >> 2);//高位用符号位填充
        System.out.println(c >>> 2);//高位填充零
    }

//    枚举类型
    enum Size {SMALL, MEDIUM, LARGE, EXTRA_LARGE};
    private static void test9() {
        Size s = Size.SMALL;
        System.out.println(s);
        System.out.println(Size.LARGE);
    }

    private static void test10() {
        String s = "hello";
        System.out.println(s.substring(1, 3));//子串
        int age = 13;
        String t = s + age;//java 中任何对象都可以转成字符串，字符串与非字符串连接后者被转化成串
        System.out.println(t);
    }

//    Java的字符串认为是不可变的
    private static void test11() {
        String s = "greeting";
        s = s.substring(0, 3) + "p!";
        System.out.println(s);
        String s2 = "help";
        System.out.println(s.equals(s2));//字符串比较函数
        System.out.println("help".equals(s2));//字符串比较函数,可以使用字符串字面量
        System.out.println("Help".equalsIgnoreCase(s2));//不区分大小写


        String s3 = "help";
        if (s3 == s2) {//不能使用 == 检测两个字符串是否相等, 此处有可能相等有可能不等
            System.out.println("test ==  for string");
        }
        if (s3.substring(0, 3) == "hel") { //相同的字符串共享，但只有字符串常量是共享的，而+和substring等操作产生的结果并不共享
            System.out.println("test substring == false");
        }
        if (s3.substring(0, 3).compareTo("hel") == 0) {
            System.out.println("test string like c style");
        }
    }

//    代码点和代码单元，一个代码点由多个代码单元组成
    private static void test12() {
        String s = "hello";
        int n = s.length();
        int cpCount = s.codePointCount(0, s.length());
        char first = s.charAt(0);
        char last = s.charAt(4);
        System.out.println(n);
        System.out.println(cpCount);
        System.out.println(first);
        System.out.println(last);

        int[] codePionts = s.codePoints().toArray();
        for(int i = 0; i < codePionts.length; i++)
            System.out.print(codePionts[i] + " ");
        System.out.println();
    }

//    stringBuilder 可以用于构建字符串，比用+或substring节约空间和时间，stringBuilder是单线程的，stringBuffer是多线程的
    private static void test13() {
        StringBuilder builder = new StringBuilder();
        builder.append("i");
        String s = "hello";
        builder.append(s);
        System.out.println(builder);
    }

//    读入
    private static void test14() {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(s);
        int age = in.nextInt();
        System.out.println(age);
        if (in.hasNext()) {
            int s1 = in.nextInt();
            System.out.println(s1);
        }
    }

//    console类
    private static void test15() {
        Console cons = System.console();
        String name = cons.readLine("User name: ");
        char[] passwd = cons.readPassword("Passwd: ");
        System.out.println(name + " " + passwd);
    }

//    格式化输出
    private static void test16() {
        double x = 1000.0/33;
        System.out.printf("%8.2f\n", x);//java支持格式化是输出，注意是printf
        String name = "shabi";
        int age = 10;
        String s = String.format("hello %s %d %<x", name, age);// %< 是格式化前面的数值
        System.out.println(s);
    }

    private static void test17() throws IOException {
        try {
            Scanner in  = new Scanner(Paths.get("/home/kunwan/javaWorkspace/Core-Java-Volume-I-fundamentals-10th-Edition/core_java/src/chapter3/myfile.txt"), "UTF-8");
//            String s1 = in.next();
//            System.out.println(s1);
            PrintWriter out = new PrintWriter("/home/kunwan/javaWorkspace/Core-Java-Volume-I-fundamentals-10th-Edition/core_java/src/chapter3/myfileOut.txt", "UTF-8");
            while (in.hasNext()){
                String tmp = in.next();
                out.write(tmp);
//                out.print(tmp);
//                System.out.println(tmp);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    java中不能像c++一样用区域的定义覆盖大区域的定义
    private static void test18() {
        int n = 10;
        {
//            int n = 11;//Error:(221, 17) java: variable n is already defined in method test18()
        }
    }

//    带label的break
    private static void test19() {
        int n = 10;
        breakLable:
        while (n-- > 0) {
            for (int i = 100; i < 110; i++) {
                System.out.println(i);
                if (i == 105)
                    break breakLable;
            }
        }
    }

    private static void test20() {
        BigInteger bigInt = new BigInteger("123456789123456789123456789");//构造器接收字符串变量
        BigInteger bigInteger = bigInt.add(BigInteger.valueOf(123));//只和bignteger做运算
        System.out.println(bigInteger);
    }

//    注意foreach语句，前面是元素而不是下标
    private static void test21() {
        int n = 10;
        int a[] = new int[n];//支持用变量定义数组大小
        int[] b = {1, 2, 3};//两种定义方法都可以
        for (int i = 0; i < 10; i++) {
            a[i] = i*2;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(a[i]);
//            System.out.println(b[i]);//尝试访问边界外的会直接异常// Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
        }
        System.out.println("********************");
        for (int element : a) {//此处的循环前面是元素而不是下标
             System.out.println(element);
        }
        System.out.println(Arrays.toString(a));
    }

//    java的数组全部在堆内存
    private static void test22() {
        int[] arr = {1, 2, 3};
        arr = new int[] {3, 4, 5, 6};
        System.out.println(Arrays.toString(arr));//匿名数组
        int[] arr2 = {1, 1, 1, 1};
        arr = arr2;//两个数组指向同一块内存
        System.out.println(Arrays.toString(arr));//匿名数组
        int[] arr3 = Arrays.copyOf(arr, arr.length);//两块内存
        System.out.println(Arrays.toString(arr3));//匿名数组

        int[] arr4 = Arrays.copyOf(arr2, arr2.length * 2);//使用此方法增加数组的大小
        int[] arr5 = Arrays.copyOf(arr2, arr2.length - 2);//使用此方法减小数组的大小
    }

    private static void test23() {
        int[] numbers = new int[50];
        int[] results = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i+1;
        }
        int n = numbers.length;
        for (int i = 0; i < results.length; i++) {
            int r = (int)(Math.random() * n);
            results[i] = numbers[r];
            numbers[r] = numbers[n-1];
            n--;
        }
        Arrays.sort(results);
        System.out.println(Arrays.toString(results));
    }

//    不规则数组和多维数组
    private static void test24() {
        int[][] arr = {
                {1, 2, 3},
                {2, 3, 4},
                {3, 4, 5}
        };
        System.out.println(Arrays.deepToString(arr));

        int n = 10;
        int[][] odds = new int[n][];
        for (int i = 0; i < n; i++) {
            odds[i] = new int[i];
        }
        for (int i = 0; i < odds.length; i++) {
            for (int j = 0; j < odds[i].length; j++) {
                odds[i][j] = i*j;
            }
        }
        System.out.println(Arrays.deepToString(odds));
    }

    public static void main(String[] args) throws Exception {
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();
        test12();
        test13();
//        test14();
//        test15();
        test16();
        test17();
        test18();
        test19();
        test20();
        test21();
        test22();
        test23();
        test24();
    }
}
