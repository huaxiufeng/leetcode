package algorithm.java;

import java.util.*;

/**
 * Created by amyhuiye on 2018/11/29.
 */
public class LC140WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        return doWordBreak(s, new HashSet<>(wordDict), new HashMap<>());
    }

    private List<String> doWordBreak(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> resultList = new ArrayList<>();
        if (s.length() == 0) {
            resultList.add("");
            return resultList;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subResultList = doWordBreak(s.substring(word.length()), wordDict, map);
                for (String sub : subResultList) {
                    resultList.add(word + (sub.length() > 0 ? " " : "") + sub);
                }
            }
        }
        map.put(s, resultList);
        return resultList;
    }

    public static void main(String[] args) {
        LC140WordBreakII solution = new LC140WordBreakII();
        System.out.println(solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
        System.out.println(solution.wordBreak("aaaaaaa", Arrays.asList("aaaa","aa","a")));
        System.out.println(solution.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(solution.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
    }
}
