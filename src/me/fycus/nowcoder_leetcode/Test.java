package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test {
    int a = 0;
    volatile boolean flag = false;

    public void writer(){
        System.out.print(flag);
    }

    public void reader(){
        flag = true;
    }
    public static void main(String[] args){
        System.out.println(Hello.class);
    }
}

class Hello{
    static{
        System.out.println("Hello");
    }
}
