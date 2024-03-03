import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(s.majorityElement(nums));
    }
}