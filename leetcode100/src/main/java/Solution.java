import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (!rows.contains(i)) {
                        rows.add(i);
                    }
                    if (!cols.contains(j)) {
                        cols.add(j);
                    }
                }
            }
        }

        for (Integer row : rows) {
            setRowZero(matrix, row);
        }

        for (Integer col : cols) {
            setColZero(matrix, col);
        }

    }

    private void setColZero(int[][] matrix, int j) {
        int rows = matrix.length;
        for (int i = 0; i < rows; i++) {
            matrix[i][j] = 0;
        }
    }

    private void setRowZero(int[][] matrix, int i) {
        int cols = matrix[0].length;
        for (int j = 0; j < cols; j++) {
            matrix[i][j] = 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        s.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}