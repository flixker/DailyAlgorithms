package me.fycus.nowcoder_leetcode;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as" two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n, generate the n th sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {
    public static void main(String[] args){
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(5));
    }
    public String countAndSay(int n){
        StringBuilder last = new StringBuilder();
        StringBuilder cur = new StringBuilder();
        last.append('1');
        for(int i = 1; i < n; i++){
            int j = 0;
            int len = last.length();
            while(j < len){
                char c = last.charAt(j);
                int k = j + 1;
                while(k < len && last.charAt(k) == c)
                    k++;
                cur.append(k - j).append(c);
                j = k;
            }
            StringBuilder tmp = last;
            last = cur;
            cur = tmp;
            cur.delete(0, len);
        }
        return last.toString();
    }
}
