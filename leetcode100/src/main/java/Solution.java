import java.util.*;

class Solution {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int len = n - 1;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < len - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - j][i];
                matrix[len - j][i] =  matrix[len - i][len - j];
                matrix[len - i][len - j] = matrix[j][len - i];
                matrix[j][len - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        s.rotate(nums);
        System.out.println(Arrays.deepToString(nums));
    }
}