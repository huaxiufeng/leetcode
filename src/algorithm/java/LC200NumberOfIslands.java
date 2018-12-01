package algorithm.java;

/**
 * Created by huaxiufeng on 18/12/1.
 */
public class LC200NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (null == grid || 0 == grid.length || null == grid[0] || 0 == grid[0].length) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]) {
                    if (grid[i][j] == '1') {
                        count++;
                        dfs(grid, visited, i, j);
                    }
                    visited[i][j] = true;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] != '1') {
            return;
        }
        visited[i][j] = true;
        dfs(grid, visited, i-1, j);
        dfs(grid, visited, i+1, j);
        dfs(grid, visited, i, j-1);
        dfs(grid, visited, i, j+1);
    }

    public static void main(String[] args) {
        LC200NumberOfIslands solution = new LC200NumberOfIslands();
        System.out.println(solution.numIslands(new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','1','1','0','0'},
                {'0','0','1','1','0'},
                {'0','0','1','1','1'}
        }));
    }
}
