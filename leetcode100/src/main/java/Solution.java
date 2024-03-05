import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (Integer i : numSet) {
            // 不剪枝会超时
            if (!numSet.contains(i - 1)) {
                int k = 0;
                while (numSet.contains(i++)) k++;
                if (max < k) max = k;
            }
        }
        return max;
    }


    public static void main(String[] args) {

        Solution s = new Solution();

        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(s.longestConsecutive(nums));

    }
}