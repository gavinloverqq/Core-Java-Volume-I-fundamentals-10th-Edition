1. java只有共有继承
2. super和this不一样，this是一个对象的引用，而super不能赋给一个对象变量
3. 注意书中p155的警告内容
4. 注意p156中可协变返回类型的内容
5. 子类覆盖父类的方法时，子类方法的可见性必须大于父类的
6. 关于equal的实现并不太懂，详见：p166
7. 重新定义了equal就需要重新定义hashcode方法
9. objects 与 object
```$xslt
java.lang.Object

Class Object is the root of the class hierarchy. Every class has Object as a superclass. All objects, including arrays, implement the methods of this class.
java.util.Objects

This class consists of static utility methods for operating on objects. These utilities include null-safe or null-tolerant methods for computing the hash code of an object, returning a string for an object, and comparing two objects.
```

