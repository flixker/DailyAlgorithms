package me.fycus;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args){
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(solution(nums1,nums2));
    }
    public static double solution(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int sumLen = len1 + len2;
        int[] both = Arrays.copyOf(nums1, sumLen);
        for(int i = 0; i < len2; i++)
            both[len1 + i] = nums2[i];
        Arrays.sort(both);
        int temp = sumLen / 2;
        if(temp * 2 == sumLen)
            return ((double)both[temp] + (double)both[temp - 1]) / 2 ;
        return both[temp];
    }
}
