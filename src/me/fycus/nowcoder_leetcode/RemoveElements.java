package me.fycus.nowcoder_leetcode;

public class RemoveElements {
    public int remobeElements(int[] A, int elem){
        int j = A.length;
        for(int i = 0; i < j; i++){
            while(A[i] == elem){
                swap(A, i, --j);
            }
        }
        return j;
    }

    public void swap(int[] a, int i, int j){
        int tem = a[i];
        a[i] = a[j];
        a[j] = tem;
    }
}
