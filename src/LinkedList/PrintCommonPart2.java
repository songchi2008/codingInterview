package LinkedList;

/**
 * 打印有序链表的公共部分
 *
 * @author 陈喻
 *         题目：给定两个有序链表的头指针head1和head2，打印出两个链表的公共部分
 *         思路：因为有序
 *         如果head1的值小于head2,则head1往下移动
 *         如果head2的值小于head1,则head2往下移动
 *         如果head1的值和head2的值相等，则打印这个值，然后head1和head2都往下移动
 *         head1或者head2有任何一个移动到null,整个过程停止
 */
public class PrintCommonPart2 {

    /**
     * 打印链表公共部分的方法
     *
     * @param head1
     * @param head2
     */
    public void printCommonPart(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return;
        }
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println("相同的部分:" + head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    public static void main(String[] args) {
        //链表一
        Node firstNode = new Node(1);
        Node firstNode1 = new Node(3);
        Node firstNode2 = new Node(5);
        Node firstNode3 = new Node(6);
        Node firstNode4 = new Node(9);
        firstNode.next = firstNode1;
        firstNode1.next = firstNode2;
        firstNode2.next = firstNode3;
        firstNode3.next = firstNode4;
        //链表二
        Node secondNode = new Node(3);
        Node secondNode1 = new Node(4);
        Node secondNode2 = new Node(5);
        Node secondNode3 = new Node(6);
        Node secondNode4 = new Node(9);
        secondNode.next = secondNode1;
        secondNode1.next = secondNode2;
        secondNode2.next = secondNode3;
        secondNode3.next = secondNode4;
        PrintCommonPart2 pcp = new PrintCommonPart2();
        pcp.printCommonPart(firstNode, secondNode);
    }
}