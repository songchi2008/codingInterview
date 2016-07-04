package LinkedList;

/**
 * Created by songchi on 16/7/1.
 */
public class NodeUtil {
    public static Node createNodeList() {
        Node firstNode = new Node(1);
        Node firstNode1 = new Node(4);
        Node firstNode2 = new Node(5);
        Node firstNode3 = new Node(7);
        Node firstNode4 = new Node(8);

        firstNode.next = firstNode1;
        firstNode1.next = firstNode2;
        firstNode2.next = firstNode3;
        firstNode3.next = firstNode4;
        return firstNode;
    }

    // 第一个生产出来的节点都不知道指谁,最后一个节点才是头结点
    // 最新制造出来的节点都是指向都节点
    public static Node createNodeList2() {
        Node head = null;
        for (int i = 0; i < 5; i++) {
            Node newNode = new Node(i, null);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public static Node createNodeList3(Integer[] arr) {
        Node head = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            Node newNode = new Node(arr[i], null);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    // 执行顺序: 打印==>移动==>打印==>移动
    // 打印出最后一个节点,则指针移动到最后一个节点的后一个节点,此时指针cur=null是结束条件
    public static void printNodeList(Node head) {
        Node cur=head;
        if (cur == null) {
            return;
        }
        while (cur != null) {
            System.out.print(cur.value + "  ");
            cur = cur.next;
        }
        System.out.println();
    }

    private static Node head = new Node(null, null);

    public static Node arrayToList(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Node p = head;
        for (int i = 0; i < arr.length; i++) {
            Node curNode = new Node(arr[i], null);
            p.next = curNode;
            p = curNode;
        }
        return p;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        Node head = arrayToList(arr);
        printNodeList(head);
    }
}
