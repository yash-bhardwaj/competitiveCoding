package com.yash.test;

class BinaryTree {
    static class Node {
        int data;
        Node left, right;
        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
    // Root of the Binary Tree
    Node root;
    private static int max = Integer.MIN_VALUE;
    // This function returns overall maximum path sum in 'res'
    // And returns max path sum going through root.
    static int findMaxUtil(Node node) {
        if (node == null) return 0;

        int l = findMaxUtil(node.left);
        int r = findMaxUtil(node.right);

        // Max path for parent call of root. This path must include at-most one child of root
        int max_single = Math.max(Math.max(l, r) + node.data, node.data);

        //  Max Top represents the sum when the Node under consideration is the root of the max sum path and no
        // ancestors of root are there in max sum path
        int max_top = Math.max(max_single, l + r + node.data);

        // Store the Maximum Result.
        max = Math.max(max, max_top);
        return max_single;
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        Node root = new Node(50);
        root.left = new Node(40);
        root.left.left = new Node(10);
        root.left.right = new Node(90);
        root.left.left.left = new Node(30);
        findMaxUtil(root);

        System.out.println("maximum path sum is : " + max);
    }
}
