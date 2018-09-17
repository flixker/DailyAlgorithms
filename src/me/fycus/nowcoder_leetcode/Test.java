package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test<T extends A> {

    static {
        System.out.println("Test static");
    }

    public static void main(String[] args) throws InterruptedException {
        Normal.Inner inner = new Normal().new Inner();
        ArrayList<Integer> list;
    }

    void f(Test<? extends A> t){}

}

class Normal {
    static {
        System.out.println("Normal static");
    }

    private String s = " ";
    private int i = 0;

    class Inner {
        {
            System.out.println("Inner");
        }

    }
}

interface A {
    default void sayHello() {
        System.out.println("A static ");
    }
}

interface B extends A {

}


abstract class Human implements A {
    public void no() {
        System.out.println("hello");
    }

    public void out() {
        System.out.println("Human static");
    }
}

class Man extends Human {
    public void out() {
        System.out.println("Man static");
    }
}
