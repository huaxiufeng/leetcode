package algorithm.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by amyhuiye on 2018/10/31.
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Map<String, Integer> lenMap= new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        lenMap.put(beginWord, 0);
        while (!queue.isEmpty()) {
            String str = queue.poll();
            int len = lenMap.get(str);
            if (str.equals(endWord)) {
                return len + 1;
            }
            Set<String> neighbors = neighborWords(str, dict);
            for (String neighbor : neighbors) {
                if (!lenMap.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    lenMap.put(neighbor, len + 1);
                }
            }
        }
        return 0;
    }

    private Set<String> neighborWords(String word, Set<String> dict) {
        Set<String> result = new HashSet<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char oldChar = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String str = new String(chars);
                if (dict.contains(str) && !str.equals(word)) {
                    result.add(str);
                }
            }
            chars[i] = oldChar;
        }
        return result;
    }

    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
    }
}
