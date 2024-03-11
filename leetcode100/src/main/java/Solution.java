import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NavigableMap;

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
        item.add(nums[i]);
        res.add(new ArrayList<>(item));
        backtrace(nums, i + 1, item, res);
        item.removeLast();
        backtrace(nums, i + 1, item, res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(s.subsets(nums));
    }
}