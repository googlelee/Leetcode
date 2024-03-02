import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (canMatch(s, i, stack)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    private static boolean canMatch(String s, int i, Stack<Character> stack) {
        if (stack.isEmpty()) return false;
        return (s.charAt(i) == ')' && stack.peek() == '(')
                || (s.charAt(i) == '}' && stack.peek() == '{')
                || (s.charAt(i) == ']' && stack.peek() == '[');
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("(){}"));
    }
}