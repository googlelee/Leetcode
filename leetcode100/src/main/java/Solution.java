import java.util.Stack;

class Solution {

    public int lengthOfLIS(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) {
                stack.add(nums[i]);
            } else if (nums[i] < stack.peek()) {
                // 为什么只换相应位置就可以？
                // 因为换相应位置不会影响已经获得的最大长度  即栈的size
                // 又达到了保存该长度最小尾部的效果  从而可以进一步搜索是否有更长的序列
                int pos = findPos(stack, nums[i]);
                stack.set(pos, nums[i]);
            } else if (nums[i] > stack.peek()) {
                stack.push(nums[i]);
            }
        }
        return stack.size();
    }

    private int findPos(Stack<Integer> stack, int target) {
        int left = 0, right = stack.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target > stack.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {10, 9, 2, 5, 1, 7, 101, 18};
        System.out.println(s.lengthOfLIS(nums));
    }
}