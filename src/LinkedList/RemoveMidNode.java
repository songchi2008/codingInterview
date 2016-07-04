package LinkedList;

/**
 * 删除链表的中间节点
 */
public class RemoveMidNode {
    public static Node removeMidNode(Node head) {
        // 1.如果链表为空或者链表长度为1,直接返回,不删除任何节点
        // 2.如果链表长度为2,返回第一个节点
        // 3.链表长度大于2,首先要找到链表中间节点的前一个节点,然后pre.next=pre.next.next;
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;   // 此时第一个节点已经找不到了,被虚拟机回收掉了
        }
        Node pre = head;
        Node search = head.next.next;
        while (search.next != null && search.next.next != null) {
            pre = pre.next;
            search = search.next.next;
        }
        //  删除中间节点
        pre.next = pre.next.next;
        return head;
    }


    // 删除最后一个节点
    public static Node removeLastNode(Node head) {
        // 1.找到倒数第二个节点,然后 last1th.next=null;
        Node pre=head;
        Node cur=head.next;
        // cur.next!=null比cur!=null少遍历一次
        // cur.next!=null 最后cur的停靠点在最后一个元素上,则pre为倒数第二个节点
        while(cur.next!=null){
            pre=cur;
            cur=cur.next;
        }
        pre.next=null;
        return head;

    }


//    public static void main(String[] args) {
//        Integer[] arr = {1, 2, 3, 4, 5,6};
//        Node head = NodeUtil.createNodeList3(arr);
//        NodeUtil.printNodeList(head);
//        removeMidNode(head);
//        NodeUtil.printNodeList(head);
//    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5,6,8,9};
        Node head = NodeUtil.createNodeList3(arr);
        NodeUtil.printNodeList(head);
        removeLastNode(head);
        NodeUtil.printNodeList(head);
    }
}
