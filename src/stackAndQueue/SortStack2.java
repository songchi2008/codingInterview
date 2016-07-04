package stackAndQueue;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 * <p>
 * help要一直把最大元素放在栈低
 */
public class SortStack2 {

    public static void main(String[] args) {
        Stack<Integer> sk = new Stack<>();
        sk.push(3);
        sk.push(2);
        sk.push(1);
        sk.push(5);
        sk.push(4);
        sortStackByStack(sk);
        while (!sk.isEmpty()) {
            System.out.println(sk.pop());
        }
    }

    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();   // cur已经被弹出来了,不在stack中了啊!!! cur元素在空中挂着呢
            while (!help.isEmpty() && cur > help.peek()) {
                stack.push(help.pop());
            }
            help.push(cur);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }

}
