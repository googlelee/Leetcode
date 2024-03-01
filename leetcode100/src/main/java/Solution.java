import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target-nums[i])) {
                return new int[]{hash.get(target - nums[i]), i};
            }
            hash.put(nums[i], i);
        }
        return new int[0];
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(s.twoSum(nums, 9)));
    }
}