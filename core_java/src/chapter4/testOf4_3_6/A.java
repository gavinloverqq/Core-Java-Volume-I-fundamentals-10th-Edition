package chapter4.testOf4_3_6;

public class A {
    private int a;

    public A(int x) {
        a = x;
    }

    public int getA() {
        return a;
    }

    public void setA(int x) {
        a = x;
    }

    public A clone() throws CloneNotSupportedException{
        return new A(a);
    }
}
