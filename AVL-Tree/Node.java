package com.company;

public class Node {
    public int data;
    Node left, right, parent;

    public Node(int data, Node left, Node right, Node parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
