import java.util.*;

class Solution {

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // 首先比较第一个元素
                int compareFirst = Integer.compare(a[0], b[0]);
                if (compareFirst != 0) {
                    return compareFirst;
                }
                // 如果第一个元素相同，则比较第二个元素
                return Integer.compare(a[1], b[1]);
            }
        });

        int len = intervals.length;
        int i = 0, j = 0;
        int start = 0;
        int end = 0;
        while (i < len) {
            start = i;
            end = intervals[i][1];
            while (j < len && end >= intervals[j][0]) {
                end = Math.max(end, intervals[j][1]);
                j++;
            }
            if (j < len) {
                int[] p = new int[]{intervals[start][0], end};
                res.add(p);
            }
            i = j;
        }

        int[] p = new int[]{intervals[start][0], end};
        res.add(p);

        int[][] ans = new int[res.size()][];
        for (int k = 0; k < res.size(); k++) {
            ans[k] = res.get(k);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = {{2, 3}, {1, 4}};
        System.out.println(Arrays.deepToString(s.merge(nums)));
    }
}