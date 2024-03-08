import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            int[] cnt = new int[26];
            for (int j = 0; j < str.length(); j++) {
                cnt[str.charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (cnt[j] > 0) {
                    sb.append("#");
                    char c = (char) ('a' + j);
                    sb.append(c);
                    sb.append(cnt[j]);
                }
            }
            List<String> list = hashMap.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(str);
            hashMap.put(sb.toString(), list);
        }
        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = {"bdddddddddd","bbbbbbbbbbc"};
        System.out.println(s.groupAnagrams(strs));
    }
}