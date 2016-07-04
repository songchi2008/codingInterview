package stackAndQueue;

import java.util.Stack;

/**
 * 将栈倒序排列
 */
public class SortStack1 {

    public static void main(String[] args) {
        Stack<Integer> stackData = new Stack<>();
        Stack<Integer> help = new Stack<>();
        stackData.push(1);
        stackData.push(2);
        stackData.push(3);
        stackData.push(4);
        stackData.push(5);

        System.out.println("stackData 栈顶元素为: " + stackData.peek());

        while (!stackData.isEmpty()) {
            help.push(stackData.pop());
        }
        while (!help.isEmpty()){
            System.out.println("help 栈为: " + help.pop());
        }
    }

}
