import java.util.ArrayList;
import java.util.NavigableMap;
import java.util.concurrent.ForkJoinPool;
import java.util.jar.JarEntry;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] cnt = new int[nums.length];
        cnt[0] = nums[0];
        cnt[1] = nums[1];
        int res = Math.max(cnt[0], cnt[1]);
        for (int i = 2; i < nums.length; i++) {
            // 第i个位置的最大值应该为i-2个之前的最大值
            int max = 0;
            for (int j = i - 2; j >= 0 ; j--) {
                if (max < cnt[j]) max = cnt[j];
            }
            cnt[i] = max + nums[i];
            if (res < cnt[i]) res = cnt[i];
        }
        return res;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] nums = {2,1,1,2};

        System.out.println(s.rob(nums));
    }
}