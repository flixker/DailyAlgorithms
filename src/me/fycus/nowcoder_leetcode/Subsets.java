package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 *
 * Note:
 *
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 *
 * For example,
 * If S =[1,2,3], a solution is:
 *
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] s){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if(s.length == 0)
            return result;
        Arrays.sort(s);
        for(int i = 0; i < s.length; i++) {
            int resLen = result.size();
            for (int j = 0; j < resLen; j++) {
                ArrayList<Integer> tmp = new ArrayList<>(result.get(j));
                tmp.add(s[i]);
                result.add(tmp);
            }
        }
        return result;
    }
}
