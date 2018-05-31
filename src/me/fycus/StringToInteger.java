package me.fycus;

public class StringToInteger {
    public static void main(String[] args){

        String s = "      -123asdf";
        String s1 = "-9223372036854775809";
        String s2 = "-00000000000000001";
        System.out.println(myAtoi(s));
        System.out.println(myAtoi(s1));
        System.out.println(myAtoi(s2));
    }
    public static int myAtoi(String str){
        char[] chars = str.toCharArray();
        int i = 0;
        long result = 0;
        boolean sign = true;
        while(i < str.length() && chars[i] == ' '){
            i++;
        }
        if(i >= str.length())
            return 0;
        char c = chars[i];
        if(c == '+');
        else if(c == '-')
            sign = false;
        else if(c >= '0' && c <= '9')
            result = Integer.parseInt(String.valueOf(c));
        else
            return 0;
        i++;
        if(!(chars[i - 1] > '0' && chars[i - 1] <= '9')) {
            while (i < str.length() && chars[i] == '0') {
                i++;
            }
        }
        int start = i;
        while(i < str.length() && chars[i] >= '0' && chars[i] <= '9') {
            result = result * 10 + Integer.parseInt(String.valueOf(chars[i]));
            i++;
        }
        int end = i;
        int length = end - start;
        if(length > 12){
            if(sign)
                return Integer.MAX_VALUE;
            return Integer.MIN_VALUE;
        }
        if(!sign)
            result *= -1;
        if(result > Integer.MAX_VALUE )
            return Integer.MAX_VALUE;
        else if(result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return (int)result;
    }
}
