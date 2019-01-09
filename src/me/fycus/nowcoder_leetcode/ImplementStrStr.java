package me.fycus.nowcoder_leetcode;

/**
 * Implement strStr().
 *
 * Returns a pointer to the first occurrence of needle in haystack,
 * or null if needle is not part of haystack.
 * 返回从出现 needle 开始的字串
 */

public class ImplementStrStr {
    public static void main(String[] args){
        ImplementStrStr implementStrStr = new ImplementStrStr();
        System.out.println(implementStrStr.strstr("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
    }
    // KMP算法
    public String strstr(String haystack, String needle){
        int hLen = haystack.length();
        int nLen = needle.length();
        if(nLen == 0)
            return haystack;
        int[] next = new int[nLen];

        // 构造 next 数组
        next[0] = -1;
        int j = 0, k = -1;
        while(j < nLen - 1){
            char c = needle.charAt(j);
            if(k == -1 || c == needle.charAt(k)) {
                k++;
                j++;
                next[j] = k;
            }
            else{
                k = next[k];
            }
        }

        j = 0;
        k = 0;
        while(j < hLen && k < nLen){
            if(k == -1 || haystack.charAt(j) == needle.charAt(k)){
                j++;
                k++;
            }
            else{
                k = next[k];
            }
        }
        return k == nLen ? haystack.substring(j - k) : null;
    }
}
