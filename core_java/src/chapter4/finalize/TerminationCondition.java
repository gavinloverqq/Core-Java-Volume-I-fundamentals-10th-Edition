package chapter4.finalize;

class Book{
    boolean checkedOut = false;
    Book(boolean checkOut){
        checkedOut = checkOut;
    }
    void checkIn(){
        checkedOut = false;
    }
    protected void finalize(){
        if (checkedOut){
            System.out.println("Error: checked out ");
        }
    }
}
public class TerminationCondition {
    public static void main(String[] args){
        Book novel = new Book(true);
        novel.checkIn();
        new Book(true);//本例的终结条件是:所有的Book对象在被当作垃圾回收前都应该被签入。但在main方法中，由于程序错误，有一本书未被签入。要是没有finalize()来验证终结条件，将很难被发现这种缺陷
        System.gc();
    }
}