
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left != right) {
            if (target > nums[left]) {
                left++;
            } else {
                right--;
            }
        }
        if (nums[left] < target) left++;
        return left;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] nums = new int[] {1,3,5,6};

        System.out.println(s.searchInsert(nums, 5));
    }
}