import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        List<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    grid[i][j] = -1;
                }
            }
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int depth = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int[] d = queue.removeFirst();
                int x = d[0];
                int y = d[1];
                for (int j = 0; j < 4; j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1) {
                        queue.add(new int[]{newX, newY});
                        grid[newX][newY] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return Math.max(depth, 0); // {{0}}
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{2, 2}, {1, 1}, {0, 0}, {2, 0}};
        System.out.println(s.orangesRotting(grid));
    }
}
