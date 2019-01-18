package me.fycus.nowcoder_leetcode;

/**
 * The string"PAYPALISHIRING"is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line:"PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    public static void main(String[] args){
        String s = "paypalishiring";
        String s1 = "a";
        System.out.println(convert(s1,1));
    }
    public static String convert(String s, int numRows){
        int len = s.length();
        if(numRows == 1 || len <= numRows)
            return s;
        StringBuilder sb = new StringBuilder();
        int G = 2 * numRows - 2;
        int step;
        int step2;
        int index;
        for(int i = 0; i < numRows; i++){
            int j = 0;
            index = i;
            if(i == 0 || i == numRows - 1){
                while(index < len){
                    sb.append(s.charAt(index));
                    index += G;
                }
            }
            else{
                step = (numRows - 1 - i) * 2;
                step2 = 2 * i;
                boolean sw = true;
                while(index < len){
                    sb.append(s.charAt(index));
                    if(sw)
                        index += step;
                    else
                        index += step2;
                    sw = !sw;
                }
            }
        }
        return sb.toString();
    }
}
