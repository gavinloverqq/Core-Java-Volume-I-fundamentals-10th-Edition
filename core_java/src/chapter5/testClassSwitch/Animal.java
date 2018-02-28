package chapter5.testClassSwitch;

import chapter4.testOf4_3_6.A;

/**
 * Created by wankun on 2018/2/27.
 */
public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void say() {
        System.out.println(name + " can say");
    }
}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    public void say() {
        System.out.println(super.getName()+ " wang wang");
    }

    public void run() {
        System.out.println("dog run");
    }



    public static void main(String[] args) {
        Dog dog = new Dog("gou");
        Animal animal = new Animal("dong wu");

        Animal[] arrAnimal = new Animal[3];
        arrAnimal[0] = dog;
        arrAnimal[0].say();
//        arrAnimal[0].run();//错误，arrAnimal[0] 是Animal类型的对象
//        dog = arrAnimal[0];

        arrAnimal[1] = animal;
        arrAnimal[1].say();

        Dog[] arrDogs = new Dog[3];
        arrDogs[0] = dog;

//        arrDogs[1] = animal;//狗是动物，但动物不一定都是狗
//        arrDogs = arrAnimal;

//        animal和dog引用了同一段内存，下面可以用对animal数组初始化，此时调用arrDogs.say()会调用一个不存在的实例域
        arrAnimal = arrDogs;
        arrAnimal[0] = new Animal("cat");//试图存储就会引发异常：java.lang.ArrayStoreException
//        arrDogs[0].say();

    }
}
