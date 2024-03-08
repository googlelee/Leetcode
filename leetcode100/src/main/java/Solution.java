import java.util.HashMap;
import java.util.Map;

class Solution {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int pre = 0;
        int res = 0;
        hashMap.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (hashMap.containsKey(pre - k)) {
                res += hashMap.get(pre - k);
            }
            hashMap.put(pre, hashMap.getOrDefault(pre, 0) + 1);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-1,1,0};
        System.out.println(s.subarraySum(nums, 0));
    }
}