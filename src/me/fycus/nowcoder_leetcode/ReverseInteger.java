package me.fycus.nowcoder_leetcode;

/**
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * If the integer's last digit is 0, what should the output be?
 * ie, cases such as 10, 100.
 *
 * Did you notice that the reversed integer might overflow?
 * Assume the input is a 32-bit integer,
 * then the reverse of 1000000003 overflows.
 * Throw an exception?
 * Good, but what if throwing an exception is not an option?
 * You would then have to re-design the function (ie, add an extra parameter).
 */
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
