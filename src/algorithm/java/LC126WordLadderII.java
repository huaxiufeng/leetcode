package algorithm.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by huaxiufeng on 18/11/27.
 */
public class LC126WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Map<String, Set<String>> neighborMap = new HashMap<>();
        Map<String, Integer> distanceMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distanceMap.put(beginWord, 0);
        while (!queue.isEmpty()) {
            int queLen = queue.size();
            for (int i = 0; i < queLen; i++) {
                String cur = queue.poll();
                int curLen = distanceMap.get(cur);
                Set<String> neighbors = findNeighbors(cur, dict);
                neighborMap.put(cur, neighbors);
                for (String str : neighbors) {
                    if (distanceMap.containsKey(str)) {
                        continue;
                    }
                    distanceMap.put(str, curLen + 1);
                    queue.offer(str);
                }
            }
        }

        List<List<String>> resultList = new ArrayList<>();
        getPath(resultList, new ArrayList<>(), beginWord, endWord, distanceMap, neighborMap);
        return resultList;
    }

    private Set<String> findNeighbors(String word, Set<String> dict) {
        Set<String> resultSet = new HashSet<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char oldc = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == oldc) {
                    continue;
                }
                chars[i] = c;
                String temp = new String(chars);
                if (dict.contains(temp)) {
                    resultSet.add(temp);
                }
            }
            chars[i] = oldc;
        }
        return resultSet;
    }

    private void getPath(List<List<String>> resultList, List<String> temp, String beginWord, String endWord, Map<String, Integer> distanceMap, Map<String, Set<String>> neighborMap) {
        Set<String> neighbors = neighborMap.get(beginWord);
        if (null == neighbors || 0 == neighbors.size()) {
            return;
        }
        temp.add(beginWord);
        if (beginWord.equals(endWord)) {
            resultList.add(new ArrayList<>(temp));
        } else {
            for (String str : neighbors) {
                if (distanceMap.getOrDefault(str, 0) == distanceMap.getOrDefault(beginWord, 0) + 1) {
                    getPath(resultList, temp, str, endWord, distanceMap, neighborMap);
                }
            }
        }
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        LC126WordLadderII solution = new LC126WordLadderII();
        System.out.println(solution.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(solution.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
    }
}
