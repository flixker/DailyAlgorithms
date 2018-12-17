package me.fycus.nowcoder_leetcode;

public class ValidNumber {
    // 这种解法有个缺陷就是无法处理大数
    public boolean isNumber(String s){
        // 例子中输入为 959440.94f 时，输出为 false
        char c = s.charAt(s.length() - 1);
        if(c == 'd' || c == 'D' || c == 'f' || c == 'F')
            return false;
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException e){}

        try{
            Double.parseDouble(s);
            return true;
        }catch(NumberFormatException e){}

        try{
            int index = 0;
            while(index < s.length() && s.charAt(index) != 'e')
                index++;
            if(index < s.length() - 1) {
                String s1 = s.substring(0, index);
                String s2 = s.substring(index + 1);
                Integer.parseInt(s1);
                Integer.parseInt(s2);
                return true;
            }
        }catch(NumberFormatException e){}

        return false;
    }
}
