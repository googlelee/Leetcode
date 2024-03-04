class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = rows;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target > matrix[mid][cols - 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left >= rows) return false;
        int row = left;
        left = 0;
        right = cols;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target > matrix[row][mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left >= cols) return false;
        return matrix[row][left] == target;
    }


    public static void main(String[] args) {

        Solution s = new Solution();

        int[][] matrix = {{1}};
        System.out.println(s.searchMatrix(matrix, 1));
    }
}