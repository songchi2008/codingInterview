package stackAndQueue;

import java.util.EmptyStackException;

/**
 * Created by songchi on 16/7/4.
 */
public class ImplStackWithArray {
    public Integer[] arr;
    public final static Integer size=100;
    // 栈顶指针
    public Integer top =-1;
    public ImplStackWithArray(){
        arr=new Integer[size];
    }

    public void push(Integer num){
        // 此时top指向数组的最后一个元素,再push的话,就要溢出了啊
        if(top==size-1){
            throw new StackOverflowError();
        }
        arr[++top]=num;
    }

    public Integer pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        Integer head=arr[top];
        // 将top指针往下移一个
        --top;
        return head;
        // 或者  return arr[top--];
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public Integer peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return arr[top];
    }

    public static void main(String[] args) {
        ImplStackWithArray myStack = new ImplStackWithArray();
        System.out.println("是空栈吗?  " + myStack.isEmpty());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        System.out.println("栈顶元素是  " + myStack.peek());
        System.out.println("弹出的栈顶元素是: "+myStack.pop());
        System.out.println("是空栈吗222?  " + myStack.isEmpty());

    }
}
