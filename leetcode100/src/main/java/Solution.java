import java.util.*;

class Solution {

    // public void rotate(int[] nums, int k) {
    //     int len = nums.length;
    //     k = k % len;
    //     int[] tmp = new int[nums.length];
    //     for (int i = 0; i < len; i++) {
    //         if (len - k + i < len) {
    //             tmp[i] = nums[len - k + i];
    //         } else {
    //             tmp[i] = nums[(len - k + i) % len];
    //         }
    //     }
    //     System.arraycopy(tmp, 0, nums, 0, len);
    // }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,4,5,6,7};
        s.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}