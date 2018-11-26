package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a set of candidate numbers ( C ) and a target number ( T ),
 * find all unique combinations in C where the candidate numbers sums to T .
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a 1, a 2, … , a k) must be in non-descending order.
 * (ie, a 1 ≤ a 2 ≤ … ≤ a k).
 * The solution set must not contain duplicate combinations.
 *
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 */
public class CombinationSum {
    public static void main(String[] args){
        CombinationSum cs = new CombinationSum();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        ArrayList<ArrayList<Integer>> reslut = cs.combinationSum(candidates, target);
        for(ArrayList<Integer> list : reslut){
            for(Integer i : list) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    ArrayList<ArrayList<Integer>> res;
    ArrayList<Integer> tmp;
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target){
        res = new ArrayList<>();
        if(target <= 0)
            return res;
        tmp = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return res;
    }

    public void dfs(int[] candidates, int index, int target){
        for(int i = index; i < candidates.length; i++){
            if(target >= candidates[i]){
                target -= candidates[i];
                tmp.add(candidates[i]);
                if(target == 0){
                    res.add(new ArrayList<>(tmp));
                }
                else{
                    dfs(candidates, i, target);
                }
                tmp.remove(tmp.size() - 1);
                target += candidates[i];
            }
            else
                break;
        }
    }
}
