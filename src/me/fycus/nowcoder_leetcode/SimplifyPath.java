package me.fycus.nowcoder_leetcode;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path ="/home/", =>"/home"
 * path ="/a/./b/../../c/", =>"/c"
 *
 * click to show corner cases.
 *
 * Corner Cases:
 *
 * Did you consider the case where path ="/../"?
 * In this case, you should return"/".
 * Another corner case is the path might contain multiple slashes'/'together, such as"/home//foo/".
 * In this case, you should ignore redundant slashes and return"/home/foo".
 */
public class SimplifyPath {
    public String simplifyPath(String path){
        if(path == null)
            return null;
        StringBuilder sb = new StringBuilder("/");
        int last = 1;
        String tmp;
        for(int i = 1; i <= path.length(); i++){
            if(i == path.length() || path.charAt(i) == '/'){
                tmp = path.substring(last, i);
                switch(tmp){
                    case "." :
                        break;
                    case "..":
                        int s = sb.length() - 2;
                        if(s < 0)
                            break;
                        while(s >= 0 && sb.charAt(s) != '/')
                            s--;
                        s++;
                        sb.delete(s, sb.length());
                        break;
                    case "":
                        break;
                    default:
                        sb.append(tmp).append('/');
                }
                last = i + 1;
            }
        }
        int len = sb.length();
        if(len > 1 && sb.charAt(len - 1) == '/')
            sb.deleteCharAt(len - 1);
        return sb.toString();
    }
}
