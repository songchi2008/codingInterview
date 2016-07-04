package LinkedList;

import java.util.Stack;

/**
 * 判断一个链表是否是回文结构
 */
public class Palindrome1 {
    public static boolean isPalindrome1(Node head) {
        // 1.把链表元素依次压榨
        // 2.每次pop栈顶元素和链表中对应的元素相比较
        Stack<Integer> stack = new Stack<>();
        Node srcHead = head;
        while (head != null) {
            stack.push(head.value);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != srcHead.value) {
                return false;
            }
            srcHead = srcHead.next;
        }
        return true;
    }

    //  此算法效率更他妈高了,使用了龟兔算法
    public static boolean isPalindrome2(Node head) {
        // 1.把链表右半边的节点依次压栈
        // 2.每次pop栈顶元素和链表中对应的元素相比较
        Node right = head.next;
        Node search = head;
        while (search.next != null && search.next.next != null) {
            search = search.next.next;
            right = right.next;
        }
        Stack<Node> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 2, 1};
        Node head = NodeUtil.createNodeList3(arr);
        NodeUtil.printNodeList(head);
        System.out.println("是否回文结构 " + isPalindrome1(head));
        System.out.println("是否回文结构2 " + isPalindrome2(head));
    }
}
