package binaryTree;

/**
 * 二叉树的节点数据结构
 */
public class TreeNode {

    public int key = 0;
    public String data = null;
    public boolean isVisited = false;
    public TreeNode leftChild = null;
    public TreeNode rightChild = null;

    public TreeNode() {
    }

    public TreeNode(int key, String data) {
        this.key = key;
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public TreeNode(int key) {
        this.key = key;
        this.leftChild = null;
        this.rightChild = null;
    }

    public static void visited(TreeNode node){
        node.isVisited=true;
        System.out.println("key is "+node.key+",  data is "+ node.data);
    }

    /**
     * 创建一棵二叉树
     * <pre>
     *           A
     *     B          C
     *  D     E    F      G
     *  </pre>
     *
     */
    public static TreeNode createNode(){
        TreeNode nodeA = new TreeNode(1,"rootA");
        TreeNode nodeB = new TreeNode(2,"B");
        TreeNode nodeC = new TreeNode(3,"C");
        TreeNode nodeD = new TreeNode(4,"D");
        TreeNode nodeE = new TreeNode(5,"E");
        TreeNode nodeF = new TreeNode(6,"F");
        TreeNode nodeG = new TreeNode(7,"G");
        nodeA.leftChild=nodeB;
        nodeA.rightChild=nodeC;
        nodeB.leftChild=nodeD;
        nodeB.rightChild=nodeE;
        nodeC.leftChild=nodeF;
        nodeC.rightChild=nodeG;
        return nodeA;
    }

    public static TreeNode createNode2(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        TreeNode node13= new TreeNode(13);
        node1.leftChild=node2;
        node1.rightChild=node3;
        node2.leftChild=node4;
        node2.rightChild=node5;
        node5.leftChild=node8;
        node5.rightChild=node11;
        node8.leftChild=node9;
        node9.leftChild=node10;
        node11.rightChild=node12;
        node12.rightChild=node13;
        node3.leftChild=node6;
        node3.rightChild=node7;

        return node1;
    }
}
