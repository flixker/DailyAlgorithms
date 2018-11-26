package me.fycus.nowcoder_leetcode;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of candidate numbers ( C ) and a target number ( T ),
 * find all unique combinations in C where the candidate numbers sums to T .
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a 1, a 2, … , a k) must be in non-descending order.
 * (ie, a 1 ≤ a 2 ≤ … ≤ a k).
 * The solution set must not contain duplicate combinations.
 *
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */
public class CombinationSum2 {
    ArrayList<ArrayList<Integer>> res;
    ArrayList<Integer> tmp;
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target){
        res = new ArrayList<>();
        if(target <= 0)
            return res;
        Arrays.sort(num);
        tmp = new ArrayList<>();
        dfs(num, 0, target);
        return res;
    }
    public void dfs(int[] num, int index, int target){
        for(int i = index; i < num.length; i++){
            if(target >= num[i]){
                tmp.add(num[i]);
                target -= num[i];
                // contains 调用 equals 比较
                // AbstractArrayList 重写了 equals 方法，比较其中的每一个元素
                if(target == 0 && !res.contains(tmp))
                    res.add(new ArrayList(tmp));
                else
                    dfs(num, i + 1, target);
                tmp.remove(tmp.size() - 1);
                target += num[i];
            }
            else
                break;
        }
    }
}
