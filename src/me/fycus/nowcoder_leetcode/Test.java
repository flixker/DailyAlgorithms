package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test<T> {

    public static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10000; i++)
            new Thread(() -> count+=1).start();
        Thread.sleep(1000);
        System.out.print(count);
    }

    void f(Test<? extends A> t){}


    public void g(Test<String> d){}
}

class Normal {
    static {
        System.out.println("Normal static");
    }

    private String s = " ";
    private int i = 0;
class Inner { {
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

class Animal{}
class Human extends Animal implements A {
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
