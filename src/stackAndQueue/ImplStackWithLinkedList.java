package stackAndQueue;

import LinkedList.Node;

import java.util.EmptyStackException;

/**
 * 用链表来实现栈
 */
public class ImplStackWithLinkedList {
    // 栈顶指针
    public Node head ;
    public ImplStackWithLinkedList(){
        head=null;
    }

    public void push(Integer num){
        Node newHead= new Node(num,head);
        head=newHead;

    }

    public Integer pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        Node oldHead=head;
        // 栈顶指针往下移动一位,等价于砍去原来的栈顶元素,要记住啊!!!
        head=head.next;
        return oldHead.value;
    }

    public boolean isEmpty(){
       return head==null;
    }

    public Integer peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return head.value;
    }

    public static void main(String[] args) {
        ImplStackWithLinkedList myStack = new ImplStackWithLinkedList();
        System.out.println("是空栈吗?  " + myStack.isEmpty());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        System.out.println("栈顶元素是  " + myStack.peek());
        System.out.println("弹出的栈顶元素是: "+myStack.pop());
        System.out.println("是空栈吗3?  " + myStack.isEmpty());

    }
}
