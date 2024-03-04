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
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.getLast() - o2.getLast();
            }
        });
        for (Integer num : hashMap.keySet()) {
            if (priorityQueue.size() < k) {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                list.add(hashMap.get(num));
                priorityQueue.add(list);
            } else if (hashMap.get(num) > priorityQueue.peek().getLast()){
                priorityQueue.poll();
                List<Integer> list1 = new ArrayList<>();
                list1.add(num);
                list1.add(hashMap.get(num));
                priorityQueue.add(list1);
            }
        }
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            res[i++] = priorityQueue.poll().getFirst();
        }
        return res;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(s.topKFrequent(nums, 2)));
    }
}