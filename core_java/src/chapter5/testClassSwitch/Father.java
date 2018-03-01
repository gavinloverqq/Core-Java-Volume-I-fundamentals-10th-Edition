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


//    用final，子类不能覆盖该方法
    public final void noInher() {
        System.out.println("final test");
    }

//    显式的标记一个方法覆盖父类方法
    @Override public boolean equals(Object other) {
        return false;
    }

//    如果父类没有这个方法，直接标记出错
//    @Override public boolean equals(Father other) {
//        return false;
//    }
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

//    用final，子类不能覆盖该方法
//    public void noInher() {
//
//    }

    public static void main(String[] args) {
        Father father = new Father(10, "laozi");
        Son son = new Son(5, 20, "erzi");

        son.name();
        son.noInher();

//        可协变返回类型
        father = father.getClas();
        father.name();

        father = son.getClas();
        father.name();

        father = father.getClas();
        father.name();

//        java类型转换失败时会抛出异常，c++失败时返回null
        Father[] arrF = new Father[3];
        arrF[0] = son;
        if (arrF[0] instanceof Son) {
            son = (Son) arrF[0];
            System.out.println("instance test");
        }

    }
}
