package algorithm.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huaxiufeng on 17/6/25.
 */
public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(null);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (null == word || 0 == word.length()) {
            return;
        }
        TrieNode curNode = root;
        for (int i = 0; i < word.length() ; i++) {
            char c = word.charAt(i);
            TrieNode nextNode = curNode.getChildren(c);
            if (null == nextNode) {
                nextNode = curNode.setChildren(c);
            }
            if (i == word.length() - 1) {
                nextNode.increaseOccurance();
            }
            curNode = nextNode;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (null == word || 0 == word.length()) {
            return false;
        }
        TrieNode curNode = root;
        for (int i = 0; i < word.length() ; i++) {
            TrieNode nextNode = curNode.getChildren(word.charAt(i));
            if (null == nextNode) {
                return false;
            }
            if (i == word.length() - 1 && nextNode.getOccurance() > 0) {
                return true;
            }
            curNode = nextNode;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (null == prefix || 0 == prefix.length()) {
            return false;
        }
        TrieNode curNode = root;
        for (int i = 0; i < prefix.length() ; i++) {
            TrieNode nextNode = curNode.getChildren(prefix.charAt(i));
            if (null == nextNode) {
                return false;
            }
            curNode = nextNode;
        }
        return true;
    }

    public static class TrieNode {
        Character c;
        int occurance;
        Map<Character, TrieNode> childrens;

        public TrieNode(Character c) {
            this.c = c;
            occurance = 0;
            childrens = new HashMap<>();
        }

        public Character getC() {
            return c;
        }

        public void setC(Character c) {
            this.c = c;
        }

        public int getOccurance() {
            return occurance;
        }

        public void increaseOccurance() {
            this.occurance++;
        }

        public TrieNode getChildren(char c) {
            return childrens.get(c);
        }

        public TrieNode setChildren(char c) {
            TrieNode childrean = new TrieNode(c);
            childrens.put(c, childrean);
            return childrean;
        }
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("hello");
        System.out.println(obj.search("hello"));
        System.out.println(obj.startsWith("he"));
    }
}
