import java.util.ArrayList;
import java.util.jar.JarEntry;

class Solution {
    public void nextPermutation(int[] nums) {
        int i, j = 0;
        // 特殊处理
        if (nums.length == 1) return;
        if (nums.length == 2) {
            swapNums(nums, 0, 1);
            return;
        }
        // 找到从尾到头第一个升序对 记为 i j
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                j = i + 1;
                break;
            }
        }
        // 如果成功 则从nums.length - 1到j找第一个大于num[i]的位置并交换两者
        if (i != -1) { // 未找到证明整个序列是降序 直接翻转即可
            for (int k = nums.length - 1; k >= j; k--) {
                if (nums[k] > nums[i]) {
                    swapNums(nums, k, i);
                    break;
                }
            }
        }
        // 此时j到nums.length - 1是降序 转为升序
        int start = j, end = nums.length - 1;
        while (start < end) {
            swapNums(nums, start, end);
            start++;
            end--;
        }
    }

    private void swapNums(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        // int[] nums = {1, 2, 3, 8, 5, 7, 6, 4};
        int[] nums = {3,2,1};
        s.nextPermutation(nums);
        for (int num : nums) System.out.print(num);
    }
}