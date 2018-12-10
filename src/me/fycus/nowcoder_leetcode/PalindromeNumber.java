package me.fycus.nowcoder_leetcode;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 *
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 *
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer",
 * you know that the reversed integer might overflow. How would you handle such case?
 *
 * There is a more generic way of solving this problem.
 */

public class PalindromeNumber {
    public static void main(String[] args){
        PalindromeNumber test = new PalindromeNumber();
        System.out.println(test.isPalindrome(1001));
    }
    public boolean isPalindrome(int x){
        if(x < 0){
            return false;
        }
        if(x >= 0 && x <= 9){
            return true;
        }
        int count = 0;
        int tmp = x;
        while(tmp != 0){
            tmp /= 10;
            count++;
        }
        return isPalindrome(x, count, 1);
    }

    public boolean isPalindrome(int x, int length, int pos){
        if(pos > length / 2)
            return true;
        int former = (x / (int)Math.pow(10, length - pos)) % 10;
        int latter = (x / (int)Math.pow(10, pos - 1)) % 10;
        if(former == latter)
            return isPalindrome(x, length, pos + 1);
        return false;
    }
}
