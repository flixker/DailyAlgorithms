package me.fycus.codeM2018;

import java.util.Scanner;
import java.util.Stack;

public class Problem4 {
    public static void main(String[] args){
        Key[][] keyboard = new Key[3][3];
        keyboard[0][0] = new Key(new char[]{'@', '!', ':'}, 0, 0);
        keyboard[0][1] = new Key(new char[]{'A', 'B', 'C'}, 0, 1);
        keyboard[0][2] = new Key(new char[]{'D', 'E', 'F'}, 0, 2);
        keyboard[1][0] = new Key(new char[]{'G', 'H', 'I'}, 1, 0);
        keyboard[1][1] = new Key(new char[]{'J', 'K', 'L'}, 1, 1);
        keyboard[1][2] = new Key(new char[]{'M', 'N', 'O'}, 1, 2);
        keyboard[2][0] = new Key(new char[]{'P', 'Q', 'R', 'S'},2, 0);
        keyboard[2][1] = new Key(new char[]{'T', 'U', 'V'}, 2, 1);
        keyboard[2][2] = new Key(new char[]{'W', 'X', 'Y', 'Z'}, 2, 2);
        boolean[][] checked = new boolean[3][3];
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                checked[i][j] = false;
        Scanner in = new Scanner(System.in);
        Stack<Key> stack = new Stack<>();
        int n = in.nextInt();
        in.nextLine();
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            int count = 0;
            String s = in.nextLine();
            Key cur = keyboard[0][0];
            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                stack.push(cur);
                while(!stack.isEmpty()){
                    cur = stack.pop();
                    count++;
                    if(cur.contains(c)){
                        stack.clear();
                        for(int l = 0; l < 3; l++)
                            for(int m = 0; m < 3; m++)
                                checked[l][m] = false;
                        break;
                    }
                    else{
                        count--;
                        if(cur.row > 0 && !checked[cur.row - 1][cur.column]) {
                            stack.push(keyboard[cur.row - 1][cur.column]);
                            checked[cur.row - 1][cur.column] = true;
                        }
                        if(cur.row < 2 && !checked[cur.row + 1][cur.column]) {
                            stack.push(keyboard[cur.row + 1][cur.column]);
                            checked[cur.row + 1][cur.column] = true;
                        }
                        if(cur.column > 0 && !checked[cur.row][cur.column - 1]) {
                            stack.push(keyboard[cur.row][cur.column - 1]);
                            checked[cur.row][cur.column - 1] = true;
                        }
                        if(cur.column < 2 && !checked[cur.row][cur.column + 1]) {
                            stack.push(keyboard[cur.row][cur.column + 1]);
                            checked[cur.row][cur.column + 1] = true;
                        }
                    }
                }
            }
            result[i] = count;
        }
        for(int i = 0; i < n; i++){
            System.out.println(result[i]);
        }
    }
}
class Key{
    char[] chars;
    int row;
    int column;
    public Key(char[] cs, int r, int c){
        chars = cs;
        row = c;
        column = c;
    }
    public boolean contains(char c){
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == c)
                return true;
        }
        return false;
    }
}