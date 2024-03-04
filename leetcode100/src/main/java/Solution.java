import java.util.*;

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int max = 0; // 维护当前位置上能达到的最远下标
        for (int i = 0; i < nums.length; i++) {
            if (max < i) return false; // 到达不了此处则false
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) return true; // 可以到达没必要继续遍历
        }
        return true;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] nums = {3,2,1,0,4};
        System.out.println(s.canJump(nums));
    }
}