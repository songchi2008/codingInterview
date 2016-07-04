package LinkedList;

/**
 * 龟兔赛跑算法
 */
public class MidSingleLinked {
    public static Integer getMiddle(Node head) {
        Node middle = head;
        Node search = head;
        while (search.next != null && search.next.next != null) {
            middle = middle.next;
            search = search.next.next;
        }
        return middle.value;
    }

    // 中间节点的下一个节点  擦,看了半天才看懂啊!!!
    public static Integer getMiddleRight(Node head) {
        Node right = head.next;
        Node search = head;
        while (search.next != null && search.next.next != null) {
            right = right.next;
            search = search.next.next;
        }
        return right.value;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};
        Node head = NodeUtil.createNodeList3(arr);
        NodeUtil.printNodeList(head);
        System.out.println("中间节点是  " + getMiddle(head));
        System.out.println("中间节点下一个节点是  " + getMiddleRight(head));
    }
}
