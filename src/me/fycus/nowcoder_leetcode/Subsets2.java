package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 *
 * Note:
 *
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 *
 * For example,
 * If S =[1,2,2], a solution is:
 *
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets2 {
    public static void main(String[] args){
        int[] num = {1,2,2};
        ArrayList<ArrayList<Integer>> a = subsetsWithDup(num);
        for(ArrayList<Integer> i : a) {
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num){
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        if(num.length == 0)
            return array;
        Arrays.sort(num);
        int last = 0;
        array.add(new ArrayList<>());
        for(int i = 0; i < num.length; i++){
            int cur = num[i];
            int size = array.size();
            if(i > 0 && cur == num[i - 1]){
                for(int j = size - 1; j > last; j--) {
                    ArrayList<Integer> tmpa = new ArrayList<>(array.get(j));
                    tmpa.add(cur);
                    array.add(tmpa);
                }
            }
            else{
                for(int j = 0; j < size; j++){
                    ArrayList<Integer> tmpa = new ArrayList<>(array.get(j));
                    tmpa.add(cur);
                    array.add(tmpa);
                }
            }
            last = size - 1;
        }
        return array;
    }

}
