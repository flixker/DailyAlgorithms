package me.fycus.nowcoder_leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * <p>
 * For example,
 * Given:
 * start ="hit"
 * end ="cog"
 * dict =["hot","dot","dog","lot","log"]
 * <p>
 * As one shortest transformation is"hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p>
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */

public class WordLadder {
    public static void main(String[] args){
        HashSet<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.print(ladderLength("hit", "cog", dict));
    }
    public static int ladderLength(String start, String end, HashSet<String> dict) {
        int res = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String cur = queue.poll();
                if (isDiffOne(cur, end))
                    return ++res;
                Iterator<String> it = dict.iterator();
                while(it.hasNext()){
                    String s = it.next();
                    if(isDiffOne(s, cur)){
                        queue.add(s);
                        it.remove();
                    }
                }
            }
            res++;
        }
        return 0;
    }

    // default: s1.length() == s2.length()
    public static boolean isDiffOne(String s1, String s2) {
        int len = s1.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
        }
        return count == 1;
    }
}
