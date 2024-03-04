import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 大顶堆
        // PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer o1, Integer o2) {
        //         return o2 - o1;
        //     }
        // });

        // 默认为小顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) priorityQueue.add(nums[i]);
            else {
                if (priorityQueue.peek() < nums[i]) {
                    priorityQueue.poll();
                    priorityQueue.add(nums[i]);
                }
            }
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(s.findKthLargest(nums, 4));
    }
}