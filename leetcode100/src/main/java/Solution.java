import java.util.*;

class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = 0, d = 0;
        for (int i = 0; i < m * n; i++) {
            res.add(matrix[x][y]);
            matrix[x][y] = 101;
            int newX = x + dx[d], newY = y + dy[d];
            if (newX < 0 || newX >= m || newY < 0 || newY >= n || matrix[newX][newY] == 101) {
                d = (d + 1) % 4;
                newX = x + dx[d];
                newY = y + dy[d];
            }
            x = newX;
            y = newY;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(s.spiralOrder(nums));
    }
}