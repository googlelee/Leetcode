import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<Integer> partitionLabels(String s) {
        List<Integer> lens = new ArrayList<>();
        int[] ends = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ends[s.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, ends[s.charAt(i) - 'a']);
            if (i == end) {
                lens.add(end - start + 1);
                start = end + 1;
            }
        }
        return lens;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String digits = "ababcbacadefegdehijhklij";
        System.out.println(s.partitionLabels(digits));
    }
}
