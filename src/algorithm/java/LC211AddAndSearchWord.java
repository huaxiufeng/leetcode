package algorithm.java;

/**
 * Created by amyhuiye on 2019/2/28.
 */
public class LC211AddAndSearchWord {

    static class WordDictionary {
        private TrieNode root;

        static class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean end = false;
        }

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int v = c - 'a';
                if (null == cur.children[v]) {
                    cur.children[v] = new TrieNode();
                }
                cur = cur.children[v];
            }
            cur.end = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return doSearch(word, root, 0);
        }

        private boolean doSearch(String word, TrieNode root, int index) {
            if (index == word.length()) {
                return root != null && root.end;
            }
            if (root == null) {
                return false;
            }
            char c = word.charAt(index);
            if (c != '.') {
                TrieNode nextRoot = root.children[c - 'a'];
                return nextRoot != null && doSearch(word, nextRoot, index + 1);
            } else {
                for (TrieNode node : root.children) {
                    if (node != null) {
                        if (doSearch(word, node, index + 1)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        {
            WordDictionary dict = new WordDictionary();
            dict.addWord("a");
            dict.addWord("ab");
            System.out.println(dict.search("ab"));
            System.out.println(dict.search("a"));
        }
        {
            WordDictionary dict = new WordDictionary();
            dict.addWord("a");
            dict.addWord("a");
            System.out.println(dict.search("aa"));
            System.out.println(dict.search("."));
            System.out.println(dict.search("a"));
        }
        {
            WordDictionary dict = new WordDictionary();
            dict.addWord("bad");
            dict.addWord("dad");
            dict.addWord("mad");
            System.out.println(dict.search("bad")); // -> true
            System.out.println(dict.search("pad")); // -> false
            System.out.println(dict.search(".ad")); // -> true
            System.out.println(dict.search("b..")); // -> true
        }
        {
            WordDictionary dict = new WordDictionary();
            dict.addWord("at");
            dict.addWord("and");
            dict.addWord("an");
            dict.addWord("add");
            System.out.println(dict.search("a")); // -> false
        }
    }
}
