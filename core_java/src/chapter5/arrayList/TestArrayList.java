package chapter5.arrayList;

import org.jetbrains.annotations.NotNull;

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

        arrS = find("ok");
        System.out.println(arrS.toString());
        System.out.println(String.valueOf(arrS));//使用string.valueof（）可避免nullPointerException
    }
}

