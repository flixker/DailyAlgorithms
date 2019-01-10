package me.fycus.nowcoder_leetcode;

public class IntegerToRoman {
    public String intToRoman(int num){
        if(num < 0 || num > 3999)
            return "";
        StringBuilder res = new StringBuilder();
        char[] dict = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int i = 0;
        while(num > 0){
            StringBuilder tmp = new StringBuilder();
            int n = num % 10;
            if(n <= 3){
                for(int j = 0; j < n; j++)
                    tmp.append(dict[i]);
            }
            else if(n == 4){
                tmp.append(dict[i]);
                tmp.append(dict[i + 1]);
            }
            else if(n == 5){
                tmp.append(dict[i + 1]);
            }
            else if(n <= 8){
                tmp.append(dict[i + 1]);
                for(int j = 0; j < n - 5; j++)
                    tmp.append(dict[i]);
            }
            else{
                tmp.append(dict[i]);
                tmp.append(dict[i + 2]);
            }
            res.insert(0, tmp.toString());
            i += 2;
            num /= 10;
        }
        return res.toString();
    }
}
