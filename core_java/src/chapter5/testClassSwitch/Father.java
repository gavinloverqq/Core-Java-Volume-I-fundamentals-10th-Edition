package chapter5.testClassSwitch;

public class Father {
    private int f;
    private String name;

    public Father(int fa, String n) {
        f = fa;
        name = n;
    }

    public int getF() {
        return f;
    }

    public String getName() {
        return name;
    }

    public void name() {
        System.out.println("father: " + name);
    }

    public Father getClas() {
       return new Father(100000, "new father");
    }
}

class Son extends Father {
    int age;

    public Son(int a, int f, String s) {
        super(f, s);
        age = a;
    }

    @Override
    public String getName() {
        return super.getName() + "'s son";
    }

    public void name() {
        System.out.println("son :" + super.getName());
        System.out.println("son :" + getName());
    }

    public int getAge() {
        return age;
    }

    public Son getClas() {
        return new Son(99999, 0, "new son");
    }

    public static void main(String[] args) {
        Father father = new Father(10, "laozi");
        Son son = new Son(5, 20, "erzi");

        son.name();

//        可协变返回类型
        father = father.getClas();
        father.name();

        father = son.getClas();
        father.name();

        father = father.getClas();
        father.name();

    }
}
