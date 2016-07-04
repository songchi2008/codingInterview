package LinkedList;

import java.util.HashSet;

/**
 * 删除无序单链表中的值重复出现的节点
 */
public class RemoveRep1 {
    public static Node removeRep1(final Node head) {
        // 1.借助hashset
        // 2. 设pre=head,从第二个节点开始遍历 即 cur = pre.next;
        // 3. cur节点如果不在set中,就把cur节点放入set,cur=cur.next , 如果在set中pre.next=cur.next,cur=cur.next
        if (head == null) {
            return null;
        }

        // pre 和 cur都是向右移动的指针,pre和cur始终保持一前一后的位置关系
        Node pre = head;
        Node cur = pre.next;
        HashSet<Integer> set = new HashSet<>();
        set.add(head.value);
        while (cur != null) {
            if (set.contains(cur.value)) {
                pre.next = cur.next;
            } else {
                set.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6};
        Node head = NodeUtil.createNodeList3(arr);
        NodeUtil.printNodeList(head);
        removeRep1(head);
        NodeUtil.printNodeList(head);
    }
}
