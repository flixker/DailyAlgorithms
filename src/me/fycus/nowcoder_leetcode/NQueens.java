package me.fycus.nowcoder_leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * The n-queens puzzle is the problem of placing n queens on an n*n chessboard
 * such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where'Q'and'.'both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
public class NQueens {

    public static void main (String[] args){
        NQueens nQueens = new NQueens();
        ArrayList<String[]> res = nQueens.solveNQueens(4);
        for(String[] ss : res){
            for(String s : ss)
                System.out.println(s);
            System.out.println();
        }
    }
    private char[][] board;
    ArrayList<String[]> resList;
    Set<Point> qPostions;

    class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        int getX(){
            return x;
        }
        int getY(){
            return y;
        }
    }

    public ArrayList<String[]> solveNQueens(int n){
        resList = new ArrayList<>();
        if(n == 1){
            resList.add(new String[]{"Q"});
            return resList;
        }
        if(n <= 3)
            return resList;
        board = new char[n][n];
        for(int i = 0;  i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        qPostions = new HashSet<>();
        dfs(0,0, n);
        return resList;
    }

    public void dfs(int x, int y, int n){
        if(qPostions.size() == n) {
            generateAns();
            return;
        }
        if(x > n - 1)
            return;
        if(isValid(x,y)){
            Point q = new Point(x,y);
            qPostions.add(q);
            //搜索下一个点
            dfs(x + 1, 0, n);
            qPostions.remove(q);
        }
        if(y < n - 1)
            dfs(x, y + 1, n);
        else if(x < n - 1)
            dfs(x + 1, 0, n);
        else
            return;
    }

    public boolean isValid(int x, int y){
        for(Point p : qPostions){
            int qx = p.getX();
            int qy = p.getY();
            if((qx - x == qy - y) || (qx - x == y - qy) || (qx == x) || (qy == y))
                return false;
        }
        return true;
    }

    public void generateAns(){
        int n = board.length;
        for(Point p : qPostions){
            board[p.getX()][p.getY()] = 'Q';
        }
        String[] ans = new String[n];
        for(int i = 0; i < n; i++){
            ans[i] = new String(board[i]);
        }
        for(Point p : qPostions)
            board[p.getX()][p.getY()] = '.';
        resList.add(ans);
    }
}
