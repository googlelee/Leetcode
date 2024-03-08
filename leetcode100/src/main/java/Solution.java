import java.util.*;

class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] leftRight = new int[nums.length];
        int[] rightLeft = new int[nums.length];
        leftRight[0] = nums[0];
        rightLeft[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            leftRight[i] = leftRight[i - 1] * nums[i];
        }
        for (int i = nums.length - 2; i >= 0 ; i--) {
            rightLeft[i] = rightLeft[i + 1] * nums[i];
        }
        int[] res = new int[nums.length];
        res[0] = rightLeft[1];
        res[nums.length - 1] = leftRight[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = leftRight[i - 1] * rightLeft[i + 1];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2};
        System.out.println(Arrays.toString(s.productExceptSelf(nums)));
    }
}