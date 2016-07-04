package LinkedList;

/**
 * 龟兔算法第二步 单链表环起始点 和环的周长
 */
public class GetCircleHeadNode {
    public static Node getCircleHeadNode(Node head) {
        // 1.判断是否有环,有环的话则慢节点才能有跟快捷点相遇的一天
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            // fast达到最后一个节点或者倒数第二个节点
            if (fast.next == null || fast.next.next == null) {
                //  推测出无环
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2.有环的情况,让慢指针回到链表的起始位置,快慢指针都一步一步走,相遇处就是环的起点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println("环的起点是   " + fast.value);

        // 3.求环的周长
        slow=slow.next;
        fast=fast.next.next;
        int n=1;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next.next;
            n++;
        }
        System.out.println("环的周长是   " + n);
        return fast;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node5;
//        NodeUtil.printNodeList(node1);//一直转圈出不来

        System.out.println(getCircleHeadNode(node1));
    }


}
