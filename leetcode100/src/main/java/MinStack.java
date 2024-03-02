import java.util.Stack;

public class MinStack {

    Stack<Integer> min;
    Stack<Integer> num;

    public MinStack() {
        min = new Stack<>();
        num = new Stack<>();
    }

    public void push(int val) {
        num.push(val);
        if (min.isEmpty() || val < min.peek()) {
            min.push(val);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        min.pop();
        num.pop();
    }

    public int top() {
        return num.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}