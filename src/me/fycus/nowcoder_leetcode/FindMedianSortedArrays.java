package me.fycus.nowcoder_leetcode;

import java.util.Arrays;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] a, int[] b){
        int length = a.length + b.length;
        int[] both = new int[length];
        for(int i = 0; i < a.length; i++)
            both[i] = a[i];
        for(int i = 0; i < b.length; i++)
            both[a.length + i] = b[i];
        Arrays.sort(both);
        if(both.length % 2 == 0)
            return (double)(both[length / 2] + both[length / 2 - 1]) / 2;
        else
            return (double)(both[length / 2]);
    }
}
