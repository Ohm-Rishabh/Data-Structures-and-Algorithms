package com.company;

public class AVL {
    public Node root;

    public AVL(Node root) {
        this.root = root;
        root.parent = null;
    }

    public void insert(Node n, Node root) {
        if (root.right == null && root.data<n.data) {
            root.right = n;
            Node k = checkBalance(root.parent)
            if (k.data != this.root.data) {
                

            }
            return;
        }
        else if (root.left == null && root.data>n.data) {
            root.left = n;
            return;
        }
        else if (root.data < n.data)
            insert(n, root.right);
        else
            insert(n, root.left);
    }

    public int height(Node root) {
        if (root == null)
            return 1;
        else {
            if (height(root.left) >= height(root.right))
                return 1+height(root.left);
            else
                return 1+height(root.right);
        }
    }

    public Node checkBalance (Node root) {
        if (height(root.left) - height(root.right) > 1 || height(root.left) - height(root.right) < -1)
            return root;
        else if (root.data == this.root.data)
            return this.root;
        return checkBalance(root.parent);
    }


    public void rotateLeft(Node y, Node x) {              //y is parent of x
        if (y.parent.data > y.data)
            y.parent.left = x;
        else
            y.parent.right = x;
        x.parent = y.parent;
        y.left = x.right;
        x.right = y;
        y.parent = x;
    }

    public void rotateRight(Node y, Node x) {
        if (y.parent.data > y.data)
            y.parent.left = x;
        else
            y.parent.right = x;
        x.parent = y.parent;
        y.right = x.left;
        x.left = y;
        y.parent = x;
    }

    /*public void rotateLeftLeft(Node z, Node y, Node x) {                 //z is the unbalanced load
        if (z.parent.data > z.data)
            z.parent.left = y;
        else
            z.parent.right = y;
        y.parent = z.parent;
        z.left = y.right;
        y.right = z;
        z.parent = y;
    }

    public void rotateRightRight(Node z, Node y, Node x) {
        y.parent = z.parent;
        z.right = y.left;
        y.right = x;
    }

    public void rotateLeftRight(Node z, Node y, Node x) {
        x.parent = z.parent;
        z.left = x.right;
        y.parent =x;
        z.parent = x;
        y.right = x.left;
    }*/
}
