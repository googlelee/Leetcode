import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> hashMap = new HashMap<>();
        hashMap.put('2', new char[]{'a', 'b', 'c'});
        hashMap.put('3', new char[]{'d', 'e', 'f'});
        hashMap.put('4', new char[]{'g', 'h', 'i'});
        hashMap.put('5', new char[]{'j', 'k', 'l'});
        hashMap.put('6', new char[]{'m', 'n', 'o'});
        hashMap.put('7', new char[]{'p', 'q', 'r', 's'});
        hashMap.put('8', new char[]{'t', 'u', 'v'});
        hashMap.put('9', new char[]{'w', 'x', 'y', 'z'});

        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char[] chars = hashMap.get(digits.charAt(i));
            if (res.isEmpty()) {
                for (int j = 0; j < chars.length; j++) {
                    res.add(String.valueOf(chars[j]));
                }
            } else {
                int pos = 0;
                ArrayList<String> tmp = new ArrayList<>();
                for (int k = 0; k < res.size(); k++) {
                    String oldStr = res.get(k);
                    for (int j = 0; j < chars.length; j++) {
                        String newStr = oldStr + chars[j];
                        tmp.add(newStr);
                    }
                }
                res = new ArrayList<>(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String digits = "";
        System.out.println(s.letterCombinations(digits));
    }
}
