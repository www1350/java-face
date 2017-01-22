package com.absurd.bitree;


import java.util.LinkedList;
import java.util.Queue;

public class BiTree<T> {
    protected Node<T> root;
    public BiTree(Node<T> root){
        this.root = root;
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node<T> n){
        print(n);
        if (n.getLeft()!=null)
            preOrder(n.getLeft());
        if (n.getRight()!=null)
            preOrder(n.getRight());
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node<T> n){
        if (n.getLeft()!=null)
            inOrder(n.getLeft());
        print(n);
        if (n.getRight()!=null)
            inOrder(n.getRight());
    }


    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node<T> n) {
        if (n.getLeft()!=null)
            inOrder(n.getLeft());
        if (n.getRight()!=null)
            inOrder(n.getRight());
        print(n);

    }

    public  void levelTravel(){
        if (root==null) return;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node<T> e =   queue.poll();
            print(e);
            if (e.getLeft()!=null) queue.add(e.getLeft());
            if (e.getRight()!=null) queue.add(e.getRight());

        }

    }


    public static BiTree buildTree(int[] inorder, int[] postorder) {
        int inStart = 0;
        int inEnd = inorder.length - 1;
        int postStart = 0;
        int postEnd = postorder.length - 1;

        Node root =  buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
        BiTree biTree = new BiTree(root);
        return biTree;
    }

    private static Node buildTree(int[] inorder, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        int rootValue = postorder[postEnd];
        Node root = new Node(rootValue);

        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                k = i;
                break;
            }
        }

        root.setLeft(
                buildTree(inorder, inStart, k - 1, postorder, postStart,
                postStart + k - (inStart + 1))
        );
        // Becuase k is not the length, it it need to -(inStart+1) to get the length
        root.setRight(
                buildTree(inorder, k + 1, inEnd, postorder, postStart + k- inStart, postEnd - 1)
        );
        // postStart+k-inStart = postStart+k-(inStart+1) +1

        return root;
    }


        public void print(Node<T> n){
        System.out.printf(""+n.getValue());
    }
}
