package LinkedList;

/**
 * Swap Nodes in Pairs
 */
public class SwapNodes {
    public static Node swapNodes(Node head){
        Node pre=null;
        Node srcNext=null;
        while (head!=null){
            srcNext=head.next;
            head.next=pre;
            pre=head;
            head=srcNext;
        }
        return pre;
    }
}
