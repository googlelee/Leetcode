import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        int[] res = new int[k];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return hashMap.get(o1) - hashMap.get(o2);
            }
        });
        for (Integer num : hashMap.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
            } else if (hashMap.get(num) > hashMap.get(priorityQueue.peek())){
                priorityQueue.poll();
                priorityQueue.add(num);
            }
        }
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            res[i++] = priorityQueue.poll();
        }
        return res;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] nums = {4,1,-1,2,-1,2,3};
        System.out.println(Arrays.toString(s.topKFrequent(nums, 2)));
    }
}