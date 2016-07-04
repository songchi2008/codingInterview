package LinkedList;

/**
 * 还要慢慢琢磨啊
 */
public class RemoveLastKthNode {
    public static Node RemoveLastKthNode(Node head,int k){
        // 1.设置快慢指针指向头结点,让块指针先走k步到达第k+1个节点,
        // 然后快慢指针一起走,当快指针到达链表末尾时,慢指针在倒数K+1的位置
        Node slow=head;
        Node fast=head;
        // 循环次数为k-1 -0+1 = k次
        // 当前节点是第1个节点,到达第K个节点要k-1步,也就是k-1次循环
        int i=0;
        while (i<k){
            fast=fast.next;
            ++i;
        }

        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7,8,9};
        Node head = NodeUtil.createNodeList3(arr);
        NodeUtil.printNodeList(head);
        RemoveLastKthNode(head,5);
        NodeUtil.printNodeList(head);

    }
}
