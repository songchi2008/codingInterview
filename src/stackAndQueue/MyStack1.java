package stackAndQueue;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 */
public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    // min栈并非只有一个元素,而是从栈顶到栈底依次递增
    public void push(int newNum) {
        if (stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            stackMin.push(newNum);
        }
        stackData.push(newNum);
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("stackData can not be null");
        }
        int data = stackData.pop();
        if (data == this.getMin()) {
            stackMin.pop();
        }
        return data;
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("stackData can not be null");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(-38);
        stack1.push(4);
        stack1.push(5);
        stack1.push(1);
        stack1.push(2);
        stack1.push(1);
        stack1.push(-3);
        stack1.push(8);
        stack1.push(9);
        System.out.println("栈中最小元素为:   "+stack1.getMin());
    }

}
