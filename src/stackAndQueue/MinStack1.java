package stackAndQueue;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 */
public class MinStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack1() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int num){
        stackData.push(num);
        if(stackMin.isEmpty()){
            stackMin.push(num);
        }else{
            if(num<=stackMin.peek()){
                stackMin.push(num);
            }
        }
    }

    public int pop(){
        return 0;
    }


    public static void main(String[] args) {
//        MinStack1 stack1 = new MinStack1();
//        stack1.push(-38);
//        stack1.push(4);
//        stack1.push(5);
//        stack1.push(1);
//        stack1.push(2);
//        stack1.push(1);
//        stack1.push(-3);
//        stack1.push(8);
//        stack1.push(9);
//        System.out.println("栈中最小元素为:   "+stack1.getMin());
    }

}
