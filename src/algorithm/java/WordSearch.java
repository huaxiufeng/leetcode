package algorithm.java;

/**
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.

 * Created by huaxiufeng on 17/7/3.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (null == board || 0 == board.length || 0 == board[0].length || null == word || 0 == word.length()) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int h = 0; h < board.length; h++) {
            for (int w = 0; w < board[h].length; w++) {
                if (word.charAt(0) == board[h][w]) {
                    if (exist(board, visited, word, 0, h, w)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, boolean[][] visited, String word, int wordIndex, int height, int width) {
        if (wordIndex >= word.length()) {
            return true;
        }
        if (height < 0 || height >= board.length || width < 0 || width >= board[0].length || board[height][width] != word.charAt(wordIndex) || visited[height][width]) {
            return false;
        }
        visited[height][width] = true;
        if (exist(board, visited, word, wordIndex+1, height-1, width) ||
                exist(board, visited, word, wordIndex+1, height+1, width) ||
                exist(board, visited, word, wordIndex+1, height, width-1) ||
                exist(board, visited, word, wordIndex+1, height, width+1)) {
            return true;
        }
        visited[height][width] = false;
        return false;
    }

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        char board[][] = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        System.out.println(solution.exist(board, "abcced"));
        System.out.println(solution.exist(board, "see"));
        System.out.println(solution.exist(board, "abcb"));
        char board1[][] = {{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}};
        System.out.println(solution.exist(board1, "aaaaaaaaaaaaa"));
    }
}
