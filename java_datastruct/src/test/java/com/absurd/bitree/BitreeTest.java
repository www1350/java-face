package com.absurd.bitree;


import org.junit.Assert;
import org.junit.Test;

public class BitreeTest {
    @Test
    public void constructor_simple_tree(){
        Node<String> node = new Node<>("a",new Node("b"),new Node("c"));
    }

    @Test
    public void preorder_simple_tree(){
        Node<String> root = new Node<>("a",new Node("b",new Node("w"),null),new Node("c",new Node("d"),new Node("f",null,new Node("e"))));
        BiTree<String> biTree = new BiTree<>(root);
        biTree.preOrder();
    }

    @Test
    public void inorder_simple_tree(){
        Node<String> root = new Node<>("a",new Node("b",new Node("w"),null),new Node("c",new Node("d"),new Node("f",null,new Node("e"))));
        BiTree<String> biTree = new BiTree<>(root);
        biTree.inOrder();
    }

    @Test
    public void postorder_simple_tree(){
        Node<String> root = new Node<>("a",new Node("b",new Node("w"),null),new Node("c",new Node("d"),new Node("f",null,new Node("e"))));
        BiTree<String> biTree = new BiTree<>(root);
        biTree.postOrder();
    }

    @Test
    public void levelTravel_simple_tree(){
        Node<String> root = new Node<>("a",new Node("b",new Node("w"),null),new Node("c",new Node("d"),new Node("f",null,new Node("e"))));
        BiTree<String> biTree = new BiTree<>(root);
        biTree.levelTravel();
    }



    @Test
    public void insert_binarySearch_tree(){
        Node<Integer> node = new Node<>(3,new Node(1),new Node(4));
        BinarySearchTree<Integer> a = new BinarySearchTree<>(node);
        a.insert(2);
        a.insert(2);
        a.inOrder();
    }

    @Test
    public void contains_binarySearch_tree(){
        Node<Integer> node = new Node<>(3,new Node(1),new Node(4));
        BinarySearchTree<Integer> a = new BinarySearchTree<>(node);
        a.insert(2);
        a.insert(2);
        Assert.assertTrue(a.contains(4));
        Assert.assertFalse(a.contains(5));
    }
}
