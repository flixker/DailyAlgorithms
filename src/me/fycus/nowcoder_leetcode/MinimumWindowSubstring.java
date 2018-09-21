package me.fycus.nowcoder_leetcode;

import java.util.*;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * S ="ADOBECODEBANC"
 * T ="ABC"
 * <p>
 * Minimum window is"BANC".
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string"".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "aa";
        String t = "aa";
        System.out.print(minWindow2(s, t));
    }


    public static String minWindow2(String s, String t){
        if(s.length() == 0 || t.length() == 0)
            return "";
        Map<Character, Integer> tCountMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            tCountMap.put(t.charAt(i), tCountMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        //窗中已经有几个字符串 t 的字母了
        int formed = 0, count = 0;
        int[] res = {Integer.MAX_VALUE, 0, 0};
        for(int i = 0; i < s.length(); i++){
            if(tCountMap.containsKey(s.charAt(i))){
                queue.add(i);
                count = windowMap.getOrDefault(s.charAt(i), 0);
                windowMap.put(s.charAt(i), ++count);
                if(count <= tCountMap.get(s.charAt(i))) {
                    formed++;
                    if(formed == t.length()){
                        //压缩左边界
                        int start;
                        while((count = windowMap.get(s.charAt(queue.peek()))) > tCountMap.get(s.charAt(queue.peek()))){
                            start = queue.poll();
                            windowMap.put(s.charAt(start), --count);
                        }
                        //计算当前窗大小
                        int length = i - queue.peek() + 1;
                        if(length < res[0]){
                            res[0] = length;
                            res[1] = queue.peek();
                            res[2] = i;
                        }
                        start = queue.poll();
                        windowMap.put(s.charAt(start), --count);
                        formed--;
                    }
                }
            }
        }
        return res[0] == Integer.MAX_VALUE ? "" : s.substring(res[1], res[2] + 1);
    }



    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0)
            return "";
        int sLen = s.length(), tLen = t.length();
        int start = -1, end = -1;
        int resStart = 0, resEnd = sLen;
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < tLen; i++)
            map.put(t.charAt(i), -1);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int lastPos = map.get(c);
                map.put(c, i);
                if (queue.isEmpty()) {
                    start = i;
                }
                else{
                    if(queue.peek() == lastPos){
                        queue.poll();
                        start = queue.peek();
                    }
                }
                queue.add(i);
                end = i;
            }
            if (queue.size() == tLen && end - start < resEnd - resStart) {
                resStart = start;
                resEnd = end;
            }
        }
        if (resEnd - resStart < sLen)
            return s.substring(resStart, resEnd + 1);
        return "";
    }
}
