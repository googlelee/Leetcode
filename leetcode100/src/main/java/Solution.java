import java.util.Stack;

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }
            if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = new int[]{7,6,4,3,1};
        System.out.println(s.maxProfit(prices));
    }
}