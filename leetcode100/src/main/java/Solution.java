import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = 1 << nums.length;
        for (int i = 0; i < n; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                int m = 1 << j;
                if ((i & m) != 0) item.add(nums[j]);
            }
            res.add(item);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(s.subsets(nums));
    }
}