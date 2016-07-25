package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的链式存储
 *
 */
public class BinaryTree2 {
    /**
     * 二叉树的节点数据结构
     */
    private class TreeNode{
        private int key=0;
        private String data=null;
        private boolean isVisited=false;
        private TreeNode leftChild=null;
        private TreeNode rightChild=null;
        public TreeNode() {
        }

        public TreeNode(int key, String data) {
            this.key = key;
            this.data = data;
            this.leftChild=null;
            this.rightChild=null;
        }

        public TreeNode(int key) {
            this.key = key;
            this.leftChild=null;
            this.rightChild=null;
        }
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
    public TreeNode createNode(){
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

    public TreeNode createNode2(){
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

    public void visited(TreeNode node){
        node.isVisited=true;
        System.out.println("key is "+node.key+",  data is "+ node.data);
    }

    // 前序遍历
    public void preOrder(TreeNode subTree){
        if(subTree!=null){
            visited(subTree);
            preOrder(subTree.leftChild);
            preOrder(subTree.rightChild);
        }
    }

    // 中序遍历
    public void inOrder(TreeNode subTree){
        if(subTree!=null){
            inOrder(subTree.leftChild);
            visited(subTree);
            inOrder(subTree.rightChild);
        }
    }

    // 后续遍历
    public void postOrder(TreeNode subTree){
        if(subTree!=null){
            postOrder(subTree.leftChild);
            postOrder(subTree.rightChild);
            visited(subTree);
        }
    }

    // 非递归前序遍历
    public void preOrderNoRec(TreeNode subTree){
        if(subTree!=null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(subTree);
            while(!stack.isEmpty()){
                TreeNode head = stack.pop();
                visited(head);
                if(head.rightChild!=null){
                    stack.push(head.rightChild);
                }
                if(head.leftChild!=null){
                    stack.push(head.leftChild);
                }
            }

        }

    }

    //  这个还需要细细琢磨啊*********************
    // 非递归中序遍历
    public void inOrderNoRec(TreeNode head){
        TreeNode cur = head;
        if(cur!=null){
            Stack<TreeNode> stack = new Stack<>();
            while(!stack.isEmpty()||cur!=null){
                if(cur!=null){
                    stack.push(cur);
                    cur=cur.leftChild;
                }else{
                    cur = stack.pop();
                    visited(cur);
                    cur=cur.rightChild;
                }
            }
        }

    }

    // 怎么能少得了层序遍历呢? 遍历顺序:自上而下,从左至右
    // 层序遍历思想:
    // 先将树的根节点入队,如果队列不为空,则进入循环
    // {
    //         将队首元素出队,并输出它
    //          如果队首元素有左孩子,左孩子入队
    //          如果队首元素有右孩子,右孩子入队
    // }

//    public void levelTravel(TreeNode root){
//        if(root==null){
//            return;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            TreeNode temp = queue.poll();
//            visited(temp);
//            if(temp.leftChild!=null){
//                queue.add(temp.leftChild);
//            }
//            if(temp.rightChild!=null){
//                queue.add(temp.rightChild);
//            }
//        }
//    }

    // 进化版:层序遍历,每一行打印一层数据
    public void levelTravel2(TreeNode root){
        if(root==null){
            return;
        }
        int current=1;   //  当前行剩余节点数
        int next=0;      //  下一行的节点总数
        int lineNo=0;    //  行号
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            current--;
            System.out.printf("%-4d", temp.key);

            if(temp.leftChild!=null){
                queue.add(temp.leftChild);
                next++;
            }
            if(temp.rightChild!=null){
                queue.add(temp.rightChild);
                next++;
            }
            if(current==0){
                //  在换行之前把当前行的行号打印出来
                System.out.print("   行号是 " + (++lineNo));
                System.out.println();
                current=next;
                next=0;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree2 binaryTree2=new BinaryTree2();
        System.out.println("前序遍历是********************");
        TreeNode root =binaryTree2.createNode2();
        binaryTree2.preOrder(root);

        System.out.println("非递归前序遍历是********************");
        binaryTree2.preOrderNoRec(root);

        System.out.println("中序遍历是********************");
        binaryTree2.inOrder(root);
        System.out.println("非递归中序遍历是********************");
        binaryTree2.inOrderNoRec(root);

        System.out.println("后序遍历是********************");
        binaryTree2.postOrder(root);

        System.out.println("非递归后序遍历是********************");

        System.out.println("层序遍历是********************");
        binaryTree2.levelTravel2(root);
    }



}