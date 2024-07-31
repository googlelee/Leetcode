class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int i = l, j = mid + 1;
        int[] temp = new int[r - l + 1];
        int k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) { temp[k++] = nums[i++]; }
        while (j <= r) { temp[k++] = nums[j++]; }
        for (int m = 0, n = l; m < temp.length; m++, n++) {
            nums[n] = temp[m];
        }
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