package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;

/**
 * Given an index k, return the k th row of the Pascal's triangle.
 *
 * For example, given k = 3,
 * Return[1,3,3,1].
 *
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */

public class PascalsTriangle2 {
    public static ArrayList<Integer> getRow(int rowIndex){
        ArrayList<Integer> result = new ArrayList<>(rowIndex + 1);
        if(rowIndex < 0)
            return result;
        result.add(1);
        int last = 1;
        for(int i = 0; i < rowIndex; i++){
            for(int j = 1; j < i + 1; j++){
                int tmp = last + result.get(j);
                last = result.get(j);
                result.set(j, tmp);
            }
            result.add(1);
        }
        return result;
    }
}
