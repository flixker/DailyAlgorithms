package me.fycus.nowcoder_leetcode;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */

import java.util.ArrayList;

public class GenerateParentheses {
    ArrayList<String> res;
    char[] tmp;
    public ArrayList<String> generateParentheses(int n){
        res = new ArrayList<>();
        if(n < 1)
            return res;
        tmp = new char[2 * n];
        dfs(0, 0, 0, n);
        return res;
    }

    public void dfs(int pos, int leftN, int rightN, int n){
        if(pos == 2 * n){
            res.add(new String(tmp));
            return;
        }
        if(leftN < n){
            tmp[pos] = '(';
            dfs(pos + 1, leftN + 1, rightN, n);
        }
        if(leftN > rightN){
            tmp[pos] = ')';
            dfs(pos + 1, leftN, rightN +1, n);
        }
    }
}
