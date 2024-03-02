import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 剪枝 否则超时
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];
            Map<Integer, Integer> hash = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (hash.containsKey(target - nums[j])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(target - nums[j]);
                    list.add(nums[j]);

                    // 去重
                    String combination = list.toString();
                    if (!seen.contains(combination)) { // 复杂度 O(1)
                        res.add(list);
                        seen.add(combination);
                    }
                }
                hash.put(nums[j], 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(s.threeSum(nums));
    }
}