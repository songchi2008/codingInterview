package LinkedList;

/**
 * Created by songchi on 16/6/30.
 */
public class ReverseList {
    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node reverseList2(Node head) {
        Node pre = head;
        Node cur = head.next;
        Node next = null;
        while (cur.next != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node firstNode = new Node(1);
        Node firstNode1 = new Node(2);
        Node firstNode2 = new Node(3);
        Node firstNode3 = new Node(4);
        Node firstNode4 = new Node(5);

        firstNode.next = firstNode1;
        firstNode1.next = firstNode2;
        firstNode2.next = firstNode3;
        firstNode3.next = firstNode4;
        reverseList(firstNode);

    }
}
