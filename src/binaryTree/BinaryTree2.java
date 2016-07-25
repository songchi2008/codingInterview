package binaryTree;

import java.util.Stack;

/**
 * 二叉树的链式存储
 *
 */
public class BinaryTree2 {

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



    public static void main(String[] args) {
        BinaryTree2 binaryTree2=new BinaryTree2();
        System.out.println("前序遍历是********************");
        TreeNode root =TreeNode.createNode2();
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

    }



}