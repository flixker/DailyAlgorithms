package me.fycus.nowcoder_leetcode;

public class ValidPalindrome {
    public static void main(String[] args){
        String s = "A man, a plan, a canal: Panama";
        String s2 = ";   '0765234  A";
        System.out.print(isPalindrome(s2));
    }
    public static boolean isPalindrome(String s){
        if(s == null || s.length() == 0)
            return true;
        s = s.toLowerCase();
        return isPalindrome(s, 0, s.length() - 1);
    }

    public static boolean isPalindrome(String s, int i, int j){
        while(i < s.length() && (s.charAt(i) < 'a' || s.charAt(i) > 'z'))
            i++;
        while(j >= 0 && (s.charAt(j) < 'a' || s.charAt(j) > 'z'))
            j--;
        if(i > j)
            return true;
        if(s.charAt(i) == s.charAt(j))
            return isPalindrome(s, ++i, --j);
        return false;
    }
}
