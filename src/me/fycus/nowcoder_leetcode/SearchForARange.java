package me.fycus.nowcoder_leetcode;

/**
 *
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return[-1, -1].
 *
 * For example,
 * Given[5, 7, 7, 8, 8, 10]and target value 8,
 * return[3, 4].
 */

public class SearchForARange {
    public int[] searchRange(int[] A, int target){
        int[] res = new int[]{-1, -1};
        int low = 0;
        int high = A.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(A[mid] < target)
                low = mid + 1;
            else if(A[mid] > target)
                high = mid - 1;
            else{
                int i = mid - 1;
                while(i >= 0 && A[i] == target)
                    i--;
                res[0] = i + 1;
                i = mid + 1;
                while(i <= A.length - 1 && A[i] == target)
                    i++;
                res[1] = i - 1;
                break;
            }
        }
        return res;
    }
}
