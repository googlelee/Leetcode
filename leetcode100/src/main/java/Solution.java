import java.util.Stack;

class Solution {

    public int maxProduct(int[] nums) {
        // max[i]存以i为结尾最大的子序列乘积
        // min[i]存以i为结尾最小的子序列乘积
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        // max在出现max出现负数时断  继续从当前位置开始
        // min在出现min出现整数时断  继续从当前位置开始
        int res = max[0] = min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // max和min其实只需要用一个变量就可以 这里是为了方便看过程用数组
            max[i] = Math.max(nums[i], Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(nums[i], Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            if (res < max[i]) res = max[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,3,-2,4};
        System.out.println(s.maxProduct(nums));
    }
}