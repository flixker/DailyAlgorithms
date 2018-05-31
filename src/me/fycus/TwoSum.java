package me.fycus;

public class TwoSum {

    private static int[] twoSum(int[] nums, int target) {
            int[] collection = new int[2];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target)
                        collection[0] = i;
                    collection[1] = j;
                }
            }
            return collection;
        }

    public static void main(String[] args){
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums,target);
        for(int i : result){
            System.out.print(i);
        }
    }
}
