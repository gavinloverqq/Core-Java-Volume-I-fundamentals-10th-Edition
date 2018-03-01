package chapter5.testHashCode;

import java.util.Objects;

public class TestHashCode {

    private int ia;
    private String s;


    public int hashCode() {
        return Objects.hash(ia, s);
    }

    public static void main(String[] args) {
//        String 的hashcode相同，StringBuider不同
        String s = "OK";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(s.hashCode() + " " + sb.hashCode());

        String t = new String("OK");
        StringBuilder tb = new StringBuilder(s);
        System.out.println(t.hashCode() + " " + tb.hashCode());





    }
}
