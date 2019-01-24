package me.fycus.nowcoder_leetcode;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S
 * such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *
 *     A solution set is:
 *     (-1,  0, 0, 1)
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 */
public class Sum4 {
    public static void main(String[] args){
        int[] num = new int[]{1, 0, -1, 0, -2, 2};
        ArrayList<ArrayList<Integer>> res = new Sum4().fourSum(num, 0);
        for(ArrayList<Integer> li : res){
            System.out.println(li);
        }
    }
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target){

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Map<Integer, ArrayList<Pair>> map = new HashMap<>();
        int len = num.length;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                int sum2 = num[i] + num[j];
                if(map.containsKey(sum2))
                    map.get(sum2).add(new Pair(i, j));
                else {
                    ArrayList<Pair> tmp = new ArrayList<>();
                    tmp.add(new Pair(i, j));
                    map.put(sum2, tmp);
                }
            }
        }

        for(Map.Entry<Integer, ArrayList<Pair>> entry : map.entrySet()){
            int a = entry.getKey();
            if(map.containsKey(target - a)){
                ArrayList<Pair> sa = entry.getValue();
                ArrayList<Pair> sb = map.get(target - a);
                if(sa == sb){
                    for(int i = 0; i < sa.size(); i++){
                        Pair p = sa.get(i);
                        for(int j = i + 1; j < sa.size(); j++){
                            Pair q = sa.get(j);
                            if(p.x == q.x || p.y == q.y || p.x == q.y || p.y == q.x)
                                continue;
                            ArrayList<Integer> li = new ArrayList<Integer>(){{
                                add(num[p.x]);
                                add(num[p.y]);
                                add(num[q.x]);
                                add(num[q.y]);
                            }};
                            Collections.sort(li);
                            if(!res.contains(li))
                                res.add(li);
                        }
                    }
                    continue;
                }
                for(Pair p : sa){
                    for(Pair q : sb){
                        if(p.x == q.x || p.y == q.y || p.x == q.y || p.y == q.x)
                            continue;
                        ArrayList<Integer> li = new ArrayList<Integer>(){{
                            add(num[p.x]);
                            add(num[p.y]);
                            add(num[q.x]);
                            add(num[q.y]);
                        }};
                        Collections.sort(li);
                        if(!res.contains(li))
                            res.add(li);
                    }
                }
                sa.clear();
                sb.clear();
            }
        }
        return res;
    }

    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
