package LinkedList;

import java.util.Stack;

/**
 * 两个单链表生成相加链表
 */
public class AddLists {
    // 1.把两个链表依次压栈,并依次出栈
    // 2.进位用ca表示
    public static Node addLists(Node head1, Node head2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (head1 != null) {
            stack1.push(head1.value);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2.value);
            head2 = head2.next;
        }

        int n1 = 0;
        int n2 = 0;
        int n = 0;    //  n=n1+n2+ca;
        int ca = 0;   //  进位指示灯

        Node pre = null;
        Node node = null;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            n1 = stack1.isEmpty() ? 0 : stack1.pop();
            n2 = stack2.isEmpty() ? 0 : stack2.pop();
            n = n1 + n2 + ca;

            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
        }

        if (ca == 1) {
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{9,3,7};
        Integer[] arr2 = new Integer[]{6,3};
        Node head1 = NodeUtil.createNodeList3(arr1);
        NodeUtil.printNodeList(head1);

        Node head2 = NodeUtil.createNodeList3(arr2);
        NodeUtil.printNodeList(head2);

        Node head = addLists(head1, head2);
        NodeUtil.printNodeList(head);

    }
}
