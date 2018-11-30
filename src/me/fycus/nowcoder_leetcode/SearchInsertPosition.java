package me.fycus.nowcoder_leetcode;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {

  // Arrays.binarySearch()即为此算法的实现，只不过它返回的是 -(insertPosition + 1)，这是为了区分以及避开0
    public int searchInsert(int[] A, int target){
        int low = 0;
        int high = A.length - 1;
        while(low <= high){
            // 这里源码使用 >>> 1 代替了除 2 操作
            int mid = (low + high) / 2;
            if(A[mid] < target){
                low = mid + 1;
            }
            else if(A[mid] > target){
                high = mid - 1;
            }
            else{
                return mid;
            }
        }
        return low;
    }
}
