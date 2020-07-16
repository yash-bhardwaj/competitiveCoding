package com.yash.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

    static class Node {
        private String data;
        private Node parent;
        private List<Node> children = new ArrayList<>();

        public Node(String name){
            this.data = name;
        }

        public Node addChild(Node child) {
            child.parent = this;
            this.children.add(child);
            return child;
        }

        public void addChildren(List<Node> children) {
            children.forEach(child -> child.setParent(this));
            this.children.addAll(children);
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public List<Node> getChildren() {
            return children;
        }

    }

    public static void main(final String[] args) throws IOException {
        Node tree = createTree();
        int minItr = 1;
        int itrs = getTree(tree.children, minItr);

        System.out.println(itrs);
    }

    private static int getTree(List<Node> children, int minItr) {
        if (children.size() == 0) return 0;
        for (Node node : children) minItr += getTree(node.children, 1);
        return minItr;
    }


    private static Node createTree() {
        Node A = new Node("A");
        Node B = A.addChild(new Node("B"));

        Node H = B.addChild(new Node("H"));
        Node I = B.addChild(new Node("I"));
        Node J = B.addChild(new Node("J"));

        Node C = A.addChild(new Node("C"));

        Node D = A.addChild(new Node("D"));

        Node E = A.addChild(new Node("E"));
        Node K = E.addChild(new Node("K"));
        Node P = K.addChild(new Node("P"));

        Node L = E.addChild(new Node("L"));
        Node O = L.addChild(new Node("O"));

        Node F = A.addChild(new Node("F"));

        Node G = A.addChild(new Node("G"));
        Node M = G.addChild(new Node("M"));

        return A;
    }
    /*
    private static Node createTree() {
        Node root = new Node("A");
        Node nodeB = root.addChild(new Node("B"));
        Node nodeBA = nodeB.addChild(new Node("BA"));
        Node nodeBB = nodeB.addChild(new Node("BB"));
        Node nodeBC = nodeB.addChild(new Node("BC"));
        Node nodeBD = nodeB.addChild(new Node("BD"));

        Node nodeC = root.addChild(new Node("C"));
        Node nodeCA = nodeC.addChild(new Node("CA"));
        Node nodeCB = nodeC.addChild(new Node("CB"));
        Node nodeCC = nodeC.addChild(new Node("CC"));
        Node nodeCD = nodeC.addChild(new Node("CD"));

        Node nodeD = root.addChild(new Node("D"));
        Node nodeDA = nodeD.addChild(new Node("DA"));
        Node nodeDB = nodeD.addChild(new Node("DB"));

        Node nodeDAA = nodeDA.addChild(new Node("DAA"));
        Node nodeDAB = nodeDA.addChild(new Node("DAB"));

        Node nodeDBA = nodeDB.addChild(new Node("DBA"));
        Node nodeDBB = nodeDB.addChild(new Node("DBB"));
        Node nodeE = root.addChild(new Node("E"));

        Node nodeEA = nodeE.addChild(new Node("EA"));
        Node nodeEB = nodeE.addChild(new Node("EB"));

        Node nodeEAA = nodeEA.addChild(new Node("EAA"));
        Node nodeEAB = nodeEA.addChild(new Node("EAB"));

        Node nodeEBA = nodeEB.addChild(new Node("EBA"));
        Node nodeEBB = nodeEB.addChild(new Node("EBB"));

        return root;
    }*/

}
