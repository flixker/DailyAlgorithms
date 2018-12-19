package me.fycus.nowcoder_leetcode;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters' ',
 * return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * For example,
 * Given s ="Hello World",
 * return 5.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s){
        int wordEnd = s.length() - 1;
        while(wordEnd >= 0 && s.charAt(wordEnd) == ' ')
            wordEnd--;
        int wordStart = wordEnd;
        while(wordStart >= 0 && s.charAt(wordStart) != ' ')
            wordStart--;
        return (wordStart <= wordEnd && wordEnd >= 0) ? wordEnd - wordStart : 0;
    }
}
