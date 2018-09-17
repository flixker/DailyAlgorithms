package me.fycus.nowcoder_leetcode;

import java.util.Stack;

public class ContainerWithMostWater {
    public static void main(String[] args){
        int[] h = new int[]{2,1};
        System.out.print(maxArea(h));
    }

    public static int maxArea3(int[] height){
        int i = 0;
        int j = height.length - 1;
        int cur = 0;
        int max = 0;
        while(i < j){
            cur = Math.min(height[i], height[j]);
            max = Math.max(max, cur * (j - i));
            while(i < height.length && height[i] <= cur)
                i++;
            while(j >= 0 && height[j] <= cur)
                j--;
        }
        return max;
    }

    // violent version
    public static int maxArea2(int[] height){
        int max = 0;
        for(int i = 0; i < height.length; i++)
            for(int j = i + 1; j < height.length; j++)
                max = Math.max(max, Math.min(height[j], height[i]) * (j - i));
        return max;
    }

    // misunderstanding version?
    public static int maxArea(int[] height){
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i < height.length; i++){
            if(!stack.isEmpty() && height[i] <= height[stack.peek()]){
                max = Math.max(max, (i - stack.peek()) * Math.min(height[i], height[stack.peek()]));
                int right = stack.pop();
                while(!stack.isEmpty() && height[stack.peek()] < height[right]){
                    stack.pop();
                }
                if(!stack.isEmpty()) {
                    max = Math.max(max, Math.min(height[stack.peek()], height[right]) * (right - stack.peek()));
                }
                i--;
            }
            else {
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int right = stack.pop();
            if(!stack.isEmpty())
                max = Math.max(max, Math.min(height[right], height[stack.peek()]) * (right - stack.peek()));
        }
        return max;
    }
}
