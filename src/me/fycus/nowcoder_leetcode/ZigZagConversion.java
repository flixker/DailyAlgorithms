package me.fycus.nowcoder_leetcode;

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
