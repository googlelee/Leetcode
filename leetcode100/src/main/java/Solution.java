import java.util.*;

class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int l = 0;
        int len = p.length();
        int end = s.length() - p.length();
        if (end < 0) return new ArrayList<>();  // 边界
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for (int i = 0; i < len; i++) {
            pCnt[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len; i++) {
            sCnt[s.charAt(i) - 'a']++;
        }

        while (l <= end) {
            if (Arrays.equals(pCnt, sCnt)) {
                res.add(l);
            }
            sCnt[s.charAt(l) - 'a']--;
            if (l + len < s.length()) { // 边界
                sCnt[s.charAt(l + len) - 'a']++;
            }
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "aaaaaaaaaa";
        String p = "aaaaaaaaaaaaa";
        System.out.println(s.findAnagrams(str, p));
    }
}