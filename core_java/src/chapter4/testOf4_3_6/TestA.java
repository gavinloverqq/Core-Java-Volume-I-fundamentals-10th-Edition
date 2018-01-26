package chapter4.testOf4_3_6;

public class TestA {
    private A aCls;

    public TestA(int t) {
        aCls = new A(t);
    }

    public A getaCls() {
        return aCls;//不可返回可变对象的访问器方法
    }

    public A getaClsFixed() throws CloneNotSupportedException {
        return (A)aCls.clone();//如果要修改一个可变的数据域的拷贝，应该用clone；
    }

    public int printAClass() {
        return aCls.getA();
    }

    public static void main(String[] args) throws Exception {
        A aCls = new A(4);
        System.out.println("a in A class is " + aCls.getA());

        TestA testA = new TestA(5);
        aCls = testA.getaCls();
        System.out.println("a in A class is " + testA.printAClass());
        aCls.setA(6);//此处可以修改TestA类中的private成员的值
        System.out.println("a in A class is " + testA.printAClass());
        aCls = testA.getaClsFixed();
        aCls.setA(7);//此处可以修改TestA类中的private成员的值
        System.out.println("a in A class is " + testA.printAClass());


    }
}
