package chapter5.arrayList;

import org.jetbrains.annotations.NotNull;
import org.omg.CORBA.IntHolder;

import java.util.ArrayList;

public class TestArrayList {


//    这里参数前加的Notnull注解，我试验来看，不加可能会抛出空指针异常，加了会抛参数错误异常
    public static void update(@NotNull ArrayList list) {
        System.out.println(list.toString());
    }

    public static ArrayList find(String s) {
        ArrayList<String> arrStr = new ArrayList<>();
        arrStr.add(s);
        return arrStr;
    }

    public static void trip(IntHolder i) {
        i.value = 3 * i.value;
    }

//    可变参数
    public static double findMax(double... values) {
        double largest = Double.NEGATIVE_INFINITY;
        for (double x : values) {
            if (x > largest)
                largest = x;
        }
        return largest;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrInt = new ArrayList<>(100);
        arrInt.add(100);
        arrInt.add(100);
        System.out.println(arrInt.size());
        arrInt.remove(0);
        System.out.println(arrInt.size());
        arrInt.trimToSize();
        arrInt.add(100);
        arrInt.add(100);
        System.out.println(arrInt.size());

//        使用set和get替代[]运算符
        arrInt.set(1, 99);
//        arrInt.set(10, 99);//超出边界：IndexOutOfBoundsException:
        System.out.println(arrInt.toString());
        System.out.println(arrInt.get(2));


        ArrayList<String> arrS = new ArrayList<>();
        update(arrS);
//        update(null);
        update(arrInt);
        System.out.println(arrS.toString());
        System.out.println(String.valueOf(arrS));//使用string.valueof（）可避免nullPointerException

//      使用@SuppressWarnings可以屏蔽warnning
        @SuppressWarnings("unchecked") ArrayList<String> result = find("ok");



//        自动装箱与自动拆相,128一内的int值被包装到固定的对象中，可用==来比较，超过128，由于在不同的对象中，需要用equal来比较
        Integer n = 3;
        Integer n2 = 3;
        if (n == n2) {
            System.out.println("n == n2");
        }

        Integer n3 = 300;
        Integer n4 = 300;
        if (n3 == n4) {
            System.out.println("n3 == n4");
        }
        if (n3.equals(n4)) {
            System.out.println("n3 equal n4");
        }

//        Integer中的值是不变的，不能通过trip函数的形式改变值
        IntHolder i = new IntHolder(3);
        trip(i);
        System.out.println(i.value);


        System.out.println(findMax(3.2, 4.8, 9.22, 2.333));
    }
}

