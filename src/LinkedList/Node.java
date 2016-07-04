package LinkedList;

public class Node {

    public Integer value;
    public Node next;
    public Node rand;

    public Node(Integer value) {
        this.value = value;
    }

    public Node() {
    }

    public Node(Integer value,Node next){
        this.value=value;
        this.next=next;
    }
}