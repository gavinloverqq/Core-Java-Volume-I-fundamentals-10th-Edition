package chapter3;

import kotlin.io.FileSystemException;
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

    public static void main(String[] args){
        test3();
        test4();
        test5();
    }
}
