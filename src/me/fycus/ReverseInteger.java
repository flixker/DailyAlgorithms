package me.fycus;

public class ReverseInteger {
    public static void main(String[] args){
        System.out.println(reverse(123));
    }
    public static int reverse(int x){
        long y  = (long)x;
        long z = 0;
        boolean sign = true;
        if(y < 0){
            sign = false;
            y *= -1;
        }
        while(y != 0){
            z  = z * 10 + (y % 10);
            y /= 10;
        }
        z = sign ? z : -1*z;
        if(z > Integer.MAX_VALUE || z < Integer.MIN_VALUE)
            return 0;
        else
            return (int)z;
    }
}
