package me.fycus.nowcoder_leetcode;

import java.util.ArrayList;

/**
 * Given an array of words and a length L, format the text such that each line has
 * exactly L characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach;
 * that is, pack as many words as you can in each line.
 * Pad extra spaces' 'when necessary so that each line has exactly L characters.
 *
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words,
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * For example,
 *
 * words:["This", "is", "an", "example", "of", "text", "justification."]
 * L:16.
 *
 * Return the formatted lines as:
 *
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * Note: Each word is guaranteed not to exceed L in length.
 *
 * Corner Cases:
 *
 * A line other than the last line might contain only one word. What should you do in this case?
 * In this case, that line should be left-justified.
 */
public class TextJustification {
    public static void main(String[] args){
        TextJustification test = new TextJustification();
        System.out.print(test.fullJustify(new String[]{""}, 2));
    }
    private ArrayList<String> res;
    public ArrayList<String> fullJustify(String[] words, int L){
        res = new ArrayList<>();
        if(words == null)
            return res;
        if(L == 0) {
            res.add("");
            return res;
        }
        pack(words, 0, L);
        return res;
    }


    public void pack(String[] words, int start, int L) {
        if(start >= words.length)
            return;
        int index = start;
        int remainingLen = L;

        // 先找到下一个切分点 index
        while (index < words.length) {
            remainingLen -= words[index].length() + 1;
            if(remainingLen < -1)
                break;
            index++;
        }

        StringBuilder sb = new StringBuilder(L);
        int num = index - start;
        if(num == 1){
            sb.append(words[start]);
            while(sb.length() < L)
                sb.append(' ');
        }
        else {
            if(index != words.length) {
                int wordsLen = remainingLen - num;
                int spaceLen = (L - wordsLen) / (num - 1);
                char[] spaces = new char[spaceLen];
                for (int i = 0; i < spaceLen; i++)
                    spaces[i] = ' ';
                int extraSpace = L - wordsLen - (spaceLen * (num - 1));
                for (int i = start; i < index - 1; i++) {
                    sb.append(words[i]);
                    sb.append(spaces);
                    if (extraSpace-- > 0)
                        sb.append(' ');
                }
                sb.append(words[index - 1]);
            }
            else {
                for (int i = start; i < index - 1; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                }
                sb.append(words[index - 1]);
                while(sb.length() < L)
                    sb.append(' ');
            }

        }
        res.add(sb.toString());
        pack(words, index, L);
    }
}
