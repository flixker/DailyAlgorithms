package me.fycus.nowcoder_leetcode;

public class Candy {
    public int candy(int[] ratings){
        int len = ratings.length;
        if(len == 0)
            return 0;
        int[] result = new int[len];
        result[0] = 1;
        int sum = 1;
        for(int i = 1; i < len; i++){
            if(ratings[i] <= ratings[i - 1]){
                result[i] = 1;
                int j = i;
                while (j > 0 && result[j - 1] == result[j] && ratings[j - 1] > ratings[j]) {
                    j--;
                    result[j]++;
                    sum++;
                }
            }
            else{
                result[i] = result[i - 1] + 1;
            }
            sum += result[i];
        }
        return sum;
    }
}
