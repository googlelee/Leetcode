import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        int[] mark = new int[nums.length];
        dfs(nums, 0, item, mark, res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> item, int[] mark, List<List<Integer>> res) {
        if (i == nums.length) {
            // 新对象保存
            res.add(new ArrayList<>(item));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (mark[j] == 0) {
                item.add(nums[j]);
                mark[j] = 1;
                dfs(nums, i + 1, item, mark, res);
                mark[j] = 0;
                item.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(s.permute(nums));
    }
}