package LinkedList;

import java.util.Stack;

/**
 * 在单链表中删除指定值的节点
 */
public class RemoveValue1 {
    public static Node removeValue1(Node head, int num) {
        // 借助一个栈
        Stack<Node> stack = new Stack<>();
        // 1.遍历链表
        while (head != null) {
            if (head.value != num) {
                stack.push(head);
            }
            head = head.next;
        }

        // 2.将栈中元素链接成链表
        while (!stack.isEmpty()) {
          stack.peek().next=head;
            head =stack.pop();
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = NodeUtil.createNodeList();
        NodeUtil.printNodeList(head);
        removeValue1(head, 4);
        NodeUtil.printNodeList(head);
    }
}
