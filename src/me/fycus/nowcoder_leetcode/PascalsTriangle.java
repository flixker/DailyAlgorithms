package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * For example, given numRows = 5,
 * Return
 *
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

public class PascalsTriangle {
    public static ArrayList<ArrayList<Integer>> generate(int numRows){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(numRows == 0)
            return result;
        result.add(new ArrayList<Integer>(){{add(1);}});
        ArrayList<Integer> last = null;
        for(int i = 1; i < numRows; i++){
            ArrayList<Integer> l = new ArrayList<Integer>(){{add(1);}};
            for(int j = 1; j < i; j++){
                l.add(last.get(j - 1) + last.get(j));
            }
            l.add(1);
            result.add(l);
            last = l;
        }
        return result;
    }
}
