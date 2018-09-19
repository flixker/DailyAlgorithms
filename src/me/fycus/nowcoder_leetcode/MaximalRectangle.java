package me.fycus.nowcoder_leetcode;


/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only ones and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 */

public class MaximalRectangle {
    public static void main(String[] args){
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.print(maximalRectangle(matrix));
    }
    public static int maximalRectangle(char[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        int length = matrix.length;
        int width = matrix[0].length;
        int maxArea = 0;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++){
                if(matrix[i][j] == '1'){
                    int lenEnd = i, widEnd = j, lenLimit = length - 1;
                    while(widEnd < width && matrix[lenEnd][widEnd] == '1'){
                        while(lenEnd < lenLimit && matrix[lenEnd + 1][widEnd] == '1')
                            lenEnd++;
                        lenLimit = lenEnd;
                        int area = (widEnd - j + 1) * (lenEnd - i + 1);
                        maxArea = maxArea > area ? maxArea : area;
                        lenEnd = i;
                        widEnd++;
                    }
                }
            }
        }
        return maxArea;
    }
}
