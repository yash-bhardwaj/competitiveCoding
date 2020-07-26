package com.yash.test;

import java.io.IOException;
import java.util.Scanner;

public class MainClass {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }


    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node) throws IOException {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    /**
     * For your reference:
     * <p>
     * SinglyLinkedListNode {
     * int data;
     * SinglyLinkedListNode next;
     * }
     */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
//        System.out.println(data);
        SinglyLinkedListNode next = new SinglyLinkedListNode(data);
        if (head == null) {
            head = next;
        } else {
            head.next = next;
            head = next;
        }
        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);

            llist.head = llist_head;
        }

        printSinglyLinkedList(llist.head);
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
