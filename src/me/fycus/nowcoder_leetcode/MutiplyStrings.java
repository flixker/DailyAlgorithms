package me.fycus.nowcoder_leetcode;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 *
 * Note: The numbers can be arbitrarily large and are non-negative.
 */
public class MutiplyStrings {
    public static void main(String[] args){
        MutiplyStrings mutiplyStrings = new MutiplyStrings();
        System.out.println(mutiplyStrings.mutiply("9", "99"));
    }
    public String mutiply(String num1, String num2){
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] tmp = new int[len1 + len2];
        for(int i = len2 - 1; i >= 0; i--){
            int carry = 0;
            for(int j = len1 - 1; j >= 0; j--){
                tmp[i + j + 1] += (num2.charAt(i) - '0') * (num1.charAt(j) - '0') + carry;
                carry = tmp[i + j + 1] / 10;
                tmp[i + j + 1] %= 10;
            }
            tmp[i] += carry;
        }
        StringBuilder sb = new StringBuilder(tmp.length);
        if(tmp[0] != 0)
            sb.append(tmp[0]);
        for(int i = 1; i < tmp.length; i++)
            sb.append(tmp[i]);
        return sb.toString();
    }
}
