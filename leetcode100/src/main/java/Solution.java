class Solution {

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                    // break; {-1,1,0} 正确为3 break是2
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,1};
        System.out.println(s.subarraySum(nums, 2));
    }
}