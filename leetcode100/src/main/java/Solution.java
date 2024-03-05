class Solution {
    // 将整个区间分成(0,p0)(p0,i)(p1,nums.length - 1)
    public void sortColors(int[] nums) {
        int p0 = 0, p1 = nums.length - 1;
        int i = 0;
        while (i <= p1) {
            if (nums[i] == 2) {
                swapNums(nums, i, p1);
                p1--;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swapNums(nums, i, p0);
                p0++;
                i++;
            }
        }
    }

    private void swapNums(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] nums = {2,0,2,1,1,0};
        s.sortColors(nums);
        for (int num : nums) System.out.println(num);
    }
}