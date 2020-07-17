package com.yash.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainClass {

    static class Node {
        private int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(final String[] args) throws IOException {
        Node bst = createTree();
        getTree(bst, "-> ");

        int depth = maxDepth(bst)+1;

        while(depth > 0) {
            swapGreater(bst);
            depth--;
        }
        nodes = new ArrayList<>();
        getTree(bst, "=> ");
    }

    public static int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        else{
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            return (1 + Math.max(l,r));
        }
    }

    private static void swapGreater(Node tree) {
        int max = tree.data;
        Node left = tree.left;
        Node right = tree.right;
        if (null != left && max < left.data) {
            tree.data = (left.data);
            tree.left.data = (max);
        } else if (null != right && max < right.data) {
            tree.data = (right.data);
            tree.right.data = (max);
        }
        if (null != left) swapGreater(left);
        if (null != right) swapGreater(right);
    }

    private static Node createTree() {
        Node A = new Node(2);
        A.left = new Node(12);
        A.right = new Node(42);
        A.left.left = new Node(22);
        A.left.right = new Node(1);
        A.right.left = new Node(82);
        A.right.right = new Node(91);
        A.left.left.left = new Node(32);
        A.left.left.right = new Node(21);
        A.left.right.left = new Node(3);
        A.left.right.right = new Node(31);
        return A;
    }
    private static ArrayList<Node> nodes = new ArrayList<>();
    private static int getTree(Node node, String appender) {

        nodes.add(node);
        System.out.println(appender + node.data);
        List<Node> list = new ArrayList<>();
        if (node.left != null) list.add(node.left);
        if (node.right != null) list.add(node.right);
        list.forEach(each ->  getTree(each, appender + appender));
        return node.data;
    }
}
