package chapter3;

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
        System.out.print(PI);
    }
    public static void main(String[] args){
        test3();
    }
}
