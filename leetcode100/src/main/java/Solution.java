import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.jar.JarEntry;

class Solution {
    public int minPathSum(int[][] grid) {
        int[][] cost = new int[grid.length][grid[0].length];
        cost[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            cost[i][0] = cost[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            cost[0][j] = cost[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                cost[i][j] = grid[i][j] + Math.min(cost[i - 1][j], cost[i][j - 1]);
            }
        }
        return cost[cost.length - 1][cost[0].length - 1];
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        int[][] nums = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        // int[][] nums = {{1}};
        System.out.println(s.minPathSum(nums));
    }
}