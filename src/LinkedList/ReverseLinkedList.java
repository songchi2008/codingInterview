package LinkedList;

/**
 * Created by songchi on 16/7/2.
 */
public class ReverseLinkedList {
    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            // 保留原始的头结点的下一个节点,因为头结点的指向马上要改变了
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head = NodeUtil.createNodeList2();
        NodeUtil.printNodeList(head);
        head = reverseList(head);
        NodeUtil.printNodeList(head);
    }
}
