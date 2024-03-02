import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        if (numRows == 1) return res;

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> lastRow = res.getLast();

            for (int j = 0; j < lastRow.size(); j++) {
                int num;
                if (j - 1 >= 0) {
                    num = lastRow.get(j) + lastRow.get(j - 1);
                } else {
                    num = lastRow.get(j);
                }
                row.add(num);
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generate(5));
    }
}