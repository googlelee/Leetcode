import java.util.*;

class Solution {

    // public boolean searchMatrix(int[][] matrix, int target) {
    //     int top = 0, bottom = matrix.length - 1;
    //     while (top < bottom) {
    //         int mid = (top + bottom) / 2;
    //         if (target < matrix[mid][0]) {
    //             bottom = mid;
    //         } else {
    //             top = mid + 1;
    //         }
    //     }
    //     for (int i = 0; i <= top; i++) {
    //         int left = 0, right = matrix[0].length - 1;
    //         while (left < right) {
    //             int mid = (left + right) / 2;
    //             if (target > matrix[i][mid]) {
    //                 left = mid + 1;
    //             } else {
    //                 right = mid;
    //             }
    //         }
    //         if (matrix[i][left] == target) return true;
    //     }
    //     return false;
    // }

    // 技巧：右上角开始有规律 一直搜即可
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < matrix.length && j >= 0) {
            if (target == matrix[i][j]) return true;
            else if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

        public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = {{-5},{6}};
        System.out.println(s.searchMatrix(nums, 6));
    }
}