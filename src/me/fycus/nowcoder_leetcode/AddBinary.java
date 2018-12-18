package me.fycus.nowcoder_leetcode;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * For example,
 * a ="11"
 * b ="1"
 * Return"100".
 */

public class AddBinary {
    public String addBinary(String a, String b) {
        String longer;
        String shorter;
        if (a.length() >= b.length()) {
            longer = a;
            shorter = b;
        } else {
            longer = b;
            shorter = a;
        }
        char[] res = new char[longer.length() + 1];
        int carry = 0;
        int i = shorter.length() - 1;
        int j = longer.length() - 1;
        while(i >= 0){
            int i2 = shorter.charAt(i) - '0';
            int i3 = longer.charAt(j) - '0';
            int additionRes = i2 + i3 + carry;
            carry = additionRes > 1 ? 1 : 0;
            res[j + 1] = (char)('0' + (additionRes % 2));
            i--;
            j--;
        }
        while(j >= 0){
            int additionRes = longer.charAt(j) - '0' + carry;
            carry = additionRes > 1 ? 1 : 0;
            res[j + 1] = (char)('0' + (additionRes % 2));
            j--;
        }
        if(carry == 1){
            res[0] = '1';
            return new String(res);
        }
        return new String(res, 1, longer.length());
    }
}
