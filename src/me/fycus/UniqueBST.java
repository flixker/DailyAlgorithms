package me.fycus;

public class UniqueBST {
    public static void main(String[] args){
        UniqueBST count = new UniqueBST();
        System.out.println(count.numTrees(3));
    }
    public int numTrees(int n){
        if(n == 0 || n == 1)
            return 1;
        int num = 0;
        for(int i = 1; i <= n; i++){
            int leftNum = numTrees(i - 1);
            int rightNum = numTrees(n - i);
            num += leftNum * rightNum;
        }
        return num;
    }
}
