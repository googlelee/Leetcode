import java.util.*;

class Solution {
//    public int[] dailyTemperatures(int[] temperatures) {
//        int[] res = new int[temperatures.length];
//        Stack<List<Integer>> stack = new Stack<>();
//        for (int i = 0; i < temperatures.length; i++) {
//            if (stack.isEmpty() || stack.peek().get(1) >= temperatures[i]) {
//                List<Integer> list = new ArrayList<>();
//                list.add(i);
//                list.add(temperatures[i]);
//                stack.push(list);
//            } else {
//                while (!stack.isEmpty() && stack.peek().get(1) < temperatures[i]) {
//                    res[stack.peek().getFirst()] = i - stack.peek().getFirst();
//                    stack.pop();
//                }
//                List<Integer> list = new ArrayList<>();
//                list.add(i);
//                list.add(temperatures[i]);
//                stack.push(list);
//            }
//        }
//        res[temperatures.length - 1] = 0;
//        return res;
//    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] nums = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(s.dailyTemperatures(nums)));
    }
}