package me.fycus.nowcoder_leetcode;

import java.util.Stack;

public class LargestRectangleArea {
    public static void main(String[] args){
        int[] a = {2, 1, 5, 6, 2, 3};
        System.out.print(largestRectangleArea2(a));
    }

    public static int largestRectangleArea2(int[] height) {
        int result=0;
        Stack<Integer> stack=new Stack<>();
        int len=height.length;
        for(int i=0;i<len;i++){
            if(stack.empty()||height[stack.peek()]<=height[i])
                stack.push(i);
            else{
                int high= height[stack.pop()];
                //如果stack为空，则表明高为high的长方形是前i个中最矮的。所以以这高度的最大矩阵为high*i
                //如果stack不为空，则比high高的矩阵为该矩阵前面stack保存的id到i都是高度大于等于high的长方形。即长度为i-stack.pop()-1
                int width=stack.empty()?i:i-stack.peek()-1;
                result= Math.max(result,high*width);
                i--;
            }
        }
        while(!stack.empty()){
            int index = stack.pop();
            int high=height[index];
            //如果stack为空，则表明高为high的长方形是从最后到index之间最短的一个，以这个高度为高度，矩阵的长度为len-index
            int width=stack.empty()?len:len-stack.peek()-1;
            result=Math.max(result,high*width);
        }
        return result;
    }


    public static int largestRectangleArea(int[] height){
        int maxArea = 0;
        for(int i = 0 ; i < height.length; i++){
            int upborder = height[i];
            for(int j = i; j >= 0; j--){
                if(height[j] < upborder){
                    upborder = height[j];
                }
                if(upborder == 0)
                    break;
                int area = upborder * (i - j + 1);
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
