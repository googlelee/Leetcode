import java.util.Stack;

class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1; // 边界
        int[] cnts = new int[n + 1];
        cnts[1] = 1;
        cnts[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            cnts[i] = cnts[i - 1] + cnts[i - 2];
        }
        return cnts[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(3));
    }
}