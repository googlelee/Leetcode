import java.util.Stack;

class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[][] cnt = new boolean[nums.length][target + 1];
        if (nums[0] <= target) { // 边界
            cnt[0][nums[0]] = true;
        }
        // cnt[i][j]代表0到i这i+1个元素能否构成target 经典背包问题
        for (int i = 1; i < cnt.length; i++) {
            for (int j = 0; j < cnt[0].length; j++) {
                if (j < nums[i]) cnt[i][j] = cnt[i - 1][j];
                else if (j == nums[i]) cnt[i][j] = true;
                else cnt[i][j] = cnt[i - 1][j] || cnt[i - 1][j - nums[i]];
            }
        }
        return cnt[nums.length - 1][target];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {100};
        System.out.println(s.canPartition(nums));
    }
}