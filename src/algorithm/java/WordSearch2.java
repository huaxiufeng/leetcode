package algorithm.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =

 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 Return ["eat","oath"].
 Note:
 You may assume that all inputs are consist of lowercase letters a-z.

 * Created by huaxiufeng on 17/7/30.
 */
public class WordSearch2 {

    Set<String> result = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int h = 0; h < board.length; h++) {
            for (int w = 0; w < board[h].length; w++) {
                dfs(board, visited, h, w, "", trie);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, boolean[][] visited, int h, int w, String str, Trie trie) {
        if (h < 0 || w < 0 || h >= board.length || w >= board[0].length) {
            return;
        }
        if (visited[h][w]) {
            return;
        }
        str += board[h][w];

        if (!trie.startsWith(str)) {
            return;
        }

        if (trie.search(str)) {
            result.add(str);
        }

        visited[h][w] = true;
        dfs(board, visited, h-1, w, str, trie);
        dfs(board, visited, h+1, w, str, trie);
        dfs(board, visited, h, w-1, str, trie);
        dfs(board, visited, h, w+1, str, trie);
        visited[h][w] = false;
    }

    public static void main(String[] args) {
        WordSearch2 solution = new WordSearch2();
        char board[][] = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(solution.findWords(board, words));
    }
}
