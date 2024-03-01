import java.util.*;

public class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) { // 考虑 i=j的情况
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1};
        s.moveZeroes(nums);
    }
}