class Solution {

    public int[] sortArray(int[] nums) {
        int[] cnt = new int[100001];

        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i] + 50000] += 1;
        }

        int[] res = new int[nums.length];
        int index = 0;
        for (int i = 0; i < cnt.length; i++) {
            for(int j = 0; j < cnt[i]; j++) {
                res[index] = i - 50000;
                index++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {5,2,3,1};
        int[] res = s.sortArray(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}