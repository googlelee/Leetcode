import java.util.ArrayList;
import java.util.Arrays;
import java.util.NavigableMap;
import java.util.concurrent.ForkJoinPool;
import java.util.jar.JarEntry;

class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] cnt = new int[nums.length];
        cnt[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            cnt[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                // 必须遍历完0到i-1找到最大
                if (nums[j] < nums[i]) {
                    cnt[i] = Math.max(cnt[j] + 1, cnt[i]);
                    if (max < cnt[i]) max = cnt[i];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(s.lengthOfLIS(nums));
    }
}