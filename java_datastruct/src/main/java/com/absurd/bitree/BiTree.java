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


        public void print(Node<T> n){
        System.out.printf(""+n.getValue());
    }
}
