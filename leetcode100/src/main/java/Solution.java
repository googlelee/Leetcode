import javax.swing.plaf.metal.MetalIconFactory;
import java.util.*;

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        // 因为互不相同且递增 所以是严格递增
        // 一旦旋转过后必有 nums[0] > nums[nums.length - 1]
        if (nums[0] <= nums[nums.length - 1]) return nums[0];
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[0]) right = mid;
            else left = mid + 1;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(s.findMin(nums));
    }
}
