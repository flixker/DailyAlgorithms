package me.fycus.nowcoder_leetcode;

public class SingleNumber2 {
    public static void main(String[] args){
        System.out.print(new SingleNumber2().singleNumber(new int[]{1}));
    }
    public int singleNumber(int[] A){
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = ones ^ A[i] & twos;
            twos = twos ^ A[i] & ~ones;
        }
        return twos;
    }
}
