import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 这儿是解决死循环的绝招  left 1 right 2 为例即可理解
            int mid = (left + right + 1) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (right >= 0 && nums[right] == target) {
            res[1] = right;
        }
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (right >= 0 && nums[right] == target) {
            res[0] = right;
        }
        return res;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(s.searchRange(nums, 10)));
    }
}