package me.fycus.nowcoder_leetcode;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicMarkableReference;


public class Test{
    public static void main(String[] args){
        double index = -0.5;
        System.out.println((int)Math.floor(index));
    }

}

class Qroxy implements InvocationHandler{
    Object o;

    Qroxy(Object o){
        this.o = o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method invoked");
        Object result = method.invoke(o,args);
        System.out.println("after method invoked");
        return result;
    }
}

interface A{
    default void test(){
        System.out.print("Interface A");
    }
}

interface B{
   default void test(){
        System.out.print("Interface B");
    }
}

