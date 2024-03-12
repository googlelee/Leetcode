import javax.swing.plaf.metal.MetalIconFactory;
import java.util.*;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) right = mid;
                else left = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(s.search(nums, 0));
    }
}
