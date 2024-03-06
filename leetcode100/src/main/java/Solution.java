import java.util.ArrayList;
import java.util.Arrays;
import java.util.NavigableMap;
import java.util.concurrent.ForkJoinPool;
import java.util.jar.JarEntry;

class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] cnt = new int[amount + 1];
        cnt[0] = 0;
        Arrays.sort(coins);
        for (int i = 1; i < cnt.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                // 一张就可以满足
                if (i - coins[j] == 0) {
                    cnt[i] = 1;
                } else if (i - coins[j] > 0) {
                    // 可以构成amount的情况
                    if (cnt[i - coins[j]] > 0) {
                        // 有多种构成i的情况下选择最小的
                        if (cnt[i] > 0) {
                            cnt[i] = Math.min(cnt[i - coins[j]] + 1, cnt[i]);
                        } else {
                            cnt[i] = cnt[i - coins[j]] + 1;
                        }
                    } else {
                        // 防止覆盖
                        if (cnt[i] <= 0) cnt[i] = -1;
                    }
                } else if (i - coins[j] < 0) {
                    // 防止覆盖
                    if (cnt[i] <= 0) cnt[i] = -1;
                }
            }
        }

        return cnt[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {186, 419, 83, 408};
        System.out.println(s.coinChange(nums, 6249));
    }
}