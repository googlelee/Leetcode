import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        res.add(new ArrayList<>());
        backtrace(nums, 0, item, res);
        return res;
    }

    private void backtrace(int[] nums, int i, List<Integer> item, List<List<Integer>> res) {
        if (i == nums.length) return;
        for (int j = i; j < nums.length; j++) {
            item.add(nums[j]);
            res.add(new ArrayList<>(item));
            backtrace(nums, j + 1, item, res);
            item.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(s.subsets(nums));
    }
}