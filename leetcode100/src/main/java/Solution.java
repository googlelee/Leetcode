import javax.swing.plaf.metal.MetalIconFactory;
import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;
        int[] in = new int[numCourses]; // 每个课的入度
        Map<Integer, List<Integer>> pre = new HashMap<>(); // 每个课对应的后续课
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> list = pre.getOrDefault(prerequisites[i][1], new ArrayList<>());
            list.add(prerequisites[i][0]);
            pre.put(prerequisites[i][1], list);
            in[prerequisites[i][0]]++;
        }

        List<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int course = queue.removeFirst();
            List<Integer> preList = pre.get(course);
            if (preList == null) continue;
            for (int num : preList) {
                in[num]--;
                if (in[num] == 0) queue.add(num);
            }
        }


        for (int i = 0; i < numCourses; i++) {
            if (in[i] != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
        System.out.println(s.canFinish(20, grid));
    }
}
