package com.absurd.bitree;


public class BinarySearchTree<T extends Comparable<T>> extends BiTree<T> {

    public BinarySearchTree(Node<T> root) {
        super(root);
    }
    

    public boolean contains(T data){
        if (root == null) {
            return false;
        }

        Node<T> cur = root;
        while (true) {
            //相等
            if (data.compareTo(cur.getValue()) == 0)
                return true;
            else if (data.compareTo(cur.getValue()) < 0) {
                if (cur.getLeft() != null)
                    cur = cur.getLeft();
                else
                    return false;
                //比结点大
            } else {
                if (cur.getRight() != null)
                    cur = cur.getRight();
                else
                    return false;
            }

        }

    }

    public boolean insert(T data) {
        if (root == null) {
            root = new Node<T>(data);
            return true;
        }
        Node<T> cur = root;
        while (true) {
            //比结点小
            if (data.compareTo(cur.getValue()) < 0) {
                if (cur.getLeft() != null)
                    cur = cur.getLeft();
                else {
                    cur.setLeft(new Node(data));
                    break;
                }
                //比结点大
            } else {
                if (cur.getRight() != null)
                    cur = cur.getRight();
                else {
                    cur.setRight(new Node(data));
                    break;
                }
            }

        }
        return true;
    }
}
