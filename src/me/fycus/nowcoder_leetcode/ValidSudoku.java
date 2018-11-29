package me.fycus.nowcoder_leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character'.'.
 */
public class ValidSudoku {
    Set<Character> set = new HashSet<>();
    public boolean isValidSudoku(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                Character ch = board[i][j];
                if(ch != '.'){
                    if(set.contains(ch))
                        return false;
                    set.add(ch);
                }
            }
            set.clear();
        }
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                Character ch = board[j][i];
                if(ch != '.'){
                    if(set.contains(ch))
                        return false;
                    set.add(ch);
                }
            }
            set.clear();
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(!isValid(board, i * 3, j * 3))
                    return false;
            }
        }

        return true;
    }
    public boolean isValid(char[][] board, int row, int col){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                Character ch = board[row + i][col + j];
                if(ch != '.'){
                    if(set.contains(ch))
                        return false;
                    set.add(ch);
                }
            }
        }
        set.clear();
        return true;
    }
}
