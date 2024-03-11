import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    String[] str = new String[]{"(", ")"};

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder item = new StringBuilder();
        backtrace(n, 0, 0, item, res);
        return res;
    }

    private void backtrace(int n, int leftLen, int rightLen, StringBuilder item, List<String> res) {
        if (item.length() >= n * 2 || leftLen > n || rightLen > n || rightLen > leftLen) {
            if (item.length() == n * 2 && isValid(item)) {
                res.add(new String(item));
            }
            return;
        }
        for (String s : str) {
            item.append(s);
            if (s.equals("(")) {
                backtrace(n, leftLen + 1, rightLen, item, res);
            } else {
                backtrace(n, leftLen, rightLen + 1, item, res);
            }
            item.deleteCharAt(item.length() - 1);
        }
    }

    private boolean isValid(StringBuilder item) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < item.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(item.charAt(i));
            } else {
                if (item.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(item.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(4));
    }
}
