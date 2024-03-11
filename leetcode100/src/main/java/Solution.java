class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] mark = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!mark[i][j] && grid[i][j] == '1') {
                    backtrace(grid, mark, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void backtrace(char[][] grid, boolean[][] mark, int i, int j) {
        mark[i][j] = true;
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};
        for (int k = 0; k < 4; k++) {
            int newI = i + di[k];
            int newJ = j + dj[k];
            if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && grid[newI][newJ] == '1' && !mark[newI][newJ]) {
                backtrace(grid, mark, newI, newJ);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        System.out.println(s.numIslands(grid));
    }
}
