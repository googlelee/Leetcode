import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        backtrace(candidates, target, 0, 0, item, res);
        return res;
    }

    private void backtrace(int[] candidates, int target, int i, int sum, List<Integer> item, List<List<Integer>> res) {
        if (sum >= target) {
            if (sum == target) {
                res.add(new ArrayList<>(item));
            }
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            if (candidates[j] > target) continue;
            item.add(candidates[j]);
            sum += candidates[j];
            backtrace(candidates, target, j, sum, item, res);
            sum -= candidates[j];
            item.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,3,6,7};
        System.out.println(s.combinationSum(nums, 7));
    }
}