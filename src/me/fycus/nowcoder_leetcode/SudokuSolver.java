package me.fycus.nowcoder_leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a program to solve a Sudoku(数独) puzzle by filling the empty cells.
 *
 * Empty cells are indicated by the character'.'.
 *
 * You may assume that there will be only one unique solution.
 */

public class SudokuSolver {
    private boolean found;
    public void solveSudoku(char[][] board){
        // 默认应该是个 9*9 的网格，就不做判断了。

        found = false;
        dfs(0, 0, board);
    }

    public void dfs(int row, int col, char[][] board){
        if(board[row][col] == '.'){
            Set<Character> set = posssibleNums(row, col, board);
            for(Character c : set){
                if(!found) {
                    board[row][col] = c;
                    if(col < 8)
                        dfs(row, col + 1, board);
                    else if(row < 8)
                        dfs(row + 1, 0, board);
                    else
                        found = true;
                    if(!found)
                        board[row][col] = '.';
                }
                else
                    return;
            }
        }
        else {
            if (col < 8)
                dfs(row, col + 1, board);
            else if (row < 8)
                dfs(row + 1, 0, board);
            else
                found = true;
        }
    }

    Set<Character> posssibleNums(int row, int col, char[][] board){
        Set<Character> res = new HashSet<Character>(){{
            for(int i = 0; i < 9; i++)
                add((char)('1' + i));
        }};
        for(int i = 0; i < 9; i++) {
            if (board[row][i] != '.')
                res.remove(board[row][i]);
            if (board[i][col] != '.')
                res.remove((board[i][col]));
        }
        int r = row - (row % 3);
        int c = col - (col % 3);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[r + i][c + j] != '.')
                    res.remove(board[r + i][c + j]);
            }
        }
        return res;
    }
}
