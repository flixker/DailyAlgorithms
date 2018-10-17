package me.fycus.nowcoder_leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 *
 * For example,
 * Given:
 * start ="hit"
 * end ="cog"
 * dict =["hot","dot","dog","lot","log"]
 * Return:
 *   [
 *     ["hit","hot","dot","dog","cog"],
 *     ["hit","hot","lot","log","cog"]
 *   ]
 *
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class WordLadder2 {
    public static void main(String[] args){
        HashSet<String> dict = new HashSet<String>(){{add("hot");add("dot");add("dog");add("lot");add("log");}};
        ArrayList<ArrayList<String>> ladders = findLadders("hit", "cog", dict);
        for(ArrayList<String> l : ladders){
            for(String s : l){
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static HashMap<String, ArrayList<String>> map = new HashMap<>();
    public static ArrayList<ArrayList<String>> res = new ArrayList<>();
    public static ArrayList<String> list = new ArrayList<>();

    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict){
        boolean found = false;
        for(String s : dict)
            map.put(s, new ArrayList<>());
        map.put(start, new ArrayList<>());
        HashSet<String> visited = new HashSet<String>(){{add(start);}};
        HashSet<String> unvisited = new HashSet<String>(dict){{add(end);remove(start);}};
        while(!visited.isEmpty() && !found){
            HashSet<String> tmp = new HashSet<>();
            for(String s : visited){
                StringBuilder sb = new StringBuilder(s);
                for(int i = 0; i < s.length(); i++){
                    char changed = sb.charAt(i);
                    for(char c = 'a'; c <= 'z'; c++){
                        sb.setCharAt(i, c);
                        String differ1 = sb.toString();
                        if(unvisited.contains(differ1)){
                            if(differ1.equals(end))
                                found = true;
                            tmp.add(differ1);
                            map.get(s).add(differ1);
                        }
                        sb.setCharAt(i, changed);
                    }
                }
            }
            unvisited.removeAll(tmp);
            visited = tmp;
        }

//        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
//            System.out.print(entry.getKey() + ":");
//            for(String s : entry.getValue())
//                System.out.print(s + " ");
//            System.out.println();
//        }

        dfs(start, end);
        return res;
        /**
         * 用队列似乎没有办法记录字典中已经被访问过的元素，导致构建的邻接表会有重复。
         *
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        boolean found = false;
        for(String s : dict)
            map.put(s, new ArrayList<>());
        map.put(end, new ArrayList<>());
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty() && !found){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String tmp = queue.poll();
                dict.remove(tmp);
                StringBuilder sb = new StringBuilder(tmp);
                for(int j = 0; j < tmp.length(); j++){
                    char changed = sb.charAt(j);
                    for(char c = 'a'; c <= 'z'; c++){
                        sb.setCharAt(j, c);
                        String differ1 = sb.toString();
                        if(differ1.equals(end)) {
                            found = true;
                            map.get(end).add(tmp);
                        }
                        if(dict.contains(differ1)){
                            queue.add(differ1);
                            map.get(differ1).add(tmp);
                        }
                        sb.setCharAt(j, changed);
                    }
                }
            }
        }
         */

    }

    public static void dfs(String start, String end){
        list.add(start);
        if(start.equals(end)){
            res.add(new ArrayList<>(list));
            return;
        }

        for(String s : map.get(start)){
            dfs(s, end);
            list.remove(list.size() - 1);
        }
    }

}
