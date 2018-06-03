package me.fycus.nowcoder_leetcode;

public class LongestPanlindromicSubString {
    public static void main(String[] args){

        String s = "babad";
        long start1 = System.currentTimeMillis();
        System.out.println(solution(s));
        long end1 = System.currentTimeMillis();
        System.out.println("cost time: " + (end1 - start1));
        long start2 = System.currentTimeMillis();
        System.out.println(betterSolution(s));
        long end2 =  System.currentTimeMillis();
        System.out.println("cost time: " + (end2 - start2));

        System.out.println(bbtterSolution(s));
    }


    //bbtter version

    public static String bbtterSolution(String s){
        //add #
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            sb.append("#");
        }

        //calculate
        int[] length = new int[sb.length()];
        int R = 2;
        int C = 1;
        length[1] = 1;
        for(int i = 2; i < sb.length(); i++){
            int ii = 2 * C - i;
            if(length[ii] < R - i)
                length[i] = length[ii];
            else{
                R++;
                while(2 * i - R >= 0 && R < sb.length() && sb.charAt(R) == sb.charAt(2 * i - R)){
                    R++;
                }
                R--;
                C = i;
                length[i] = R - i;
            }
        }

        //find
        int max = 0;
        int index = 0;
        for(int i = 0; i < length.length; i++){
            if(length[i] > max){
                max = length[i];
                index = i;
            }
        }
        System.out.println("index: "  + index + "   length: " + max);
        return s.substring((index - max) / 2, (index + max - 2) / 2 + 1);
    }

    //better version
    //N^2
    //21ms
    public static String betterSolution(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    //origin
    //221ms
    //StringBuffer is not neccessary
    public static String solution(String s){
        String result = null;
        StringBuffer temp = new StringBuffer();
        int max = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            temp.delete(0,temp.length());
            temp.append(chars[i]);
            int count = 1;
            int head = i - 1;
            int end = i + 1;
            while(head >= 0 || end < chars.length){
                if(head >= 0 && chars[head] == chars[i]){
                    temp.append(chars[i]);
                    count++;
                    head--;
                }
                if(end < chars.length && chars[end] == chars[i]){
                    temp.append(chars[i]);
                    count++;
                    end++;
                }
                else{
                    break;
                }
            }
            while(head >= 0 && end < chars.length && chars[head] == chars[end]){
                count += 2;
                temp.append(chars[end++]);
                temp.insert(0,chars[head--]);
            }
            if(max < count){
                result = temp.toString();
                max = count;
            }
        }
        return result;
    }
}
