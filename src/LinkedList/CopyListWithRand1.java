package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制含有随机指针节点的链表
 */
public class CopyListWithRand1 {

    // 返回复制后的链表
    public static Node CopyListWithRand1(Node head){
        // 1.需要借助一个hashMap,将原链表的 node和node.value 键值对
        Map<Node,Node> hashMap =new HashMap<>();
        Node cur=head;
        while(cur!=null){
            hashMap.put(cur,new Node(cur.value));
            cur=cur.next;
        }
        // 2.遍历hashmap

        cur=head;
        while(cur!=null){
            hashMap.get(cur).next=hashMap.get(cur.next);
            hashMap.get(cur).rand=hashMap.get(cur.rand);
            cur=cur.next;
        }
        return hashMap.get(head);
    }
}
