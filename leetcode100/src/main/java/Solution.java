import java.util.*;

class Solution {
    public int maxSubArray(int[] nums) {
        int[] maxSum = new int[nums.length];
        maxSum[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + maxSum[i - 1] > nums[i]) {
                maxSum[i] = nums[i] + maxSum[i - 1];
            } else {
                maxSum[i] = nums[i];
            }
            if (maxSum[i] > res) {
                res = maxSum[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {5,4,-1,7,8};
        System.out.println(s.maxSubArray(nums));
    }
}