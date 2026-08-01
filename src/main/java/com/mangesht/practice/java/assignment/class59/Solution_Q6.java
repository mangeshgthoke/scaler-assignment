package com.mangesht.practice.java.assignment.class59;

import java.util.Scanner;

public class Solution_Q6 {

    /**
     * Design and implement a Linked List data structure.
     * A node in a linked list should have the following attributes - an integer value and a pointer to the next node.
     *
     * It should support the following operations:
     *
     * insert_node(position, value) - To insert the input value at the given position in the linked list.
     * delete_node(position) - Delete the value at the given position from the linked list.
     * print_ll() - Print the entire linked list, such that each element is followed by a single space (no trailing spaces).
     * Note:
     *
     * If an input position does not satisfy the constraint, no action is required.
     * Each print query has to be executed in a new line.
     */


    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // 1. The Head Pointer
    public static Node head = null;

    // 2. The Cached Size Variable (O(1) tracking)
    public static int size = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int numberOfOperations = scanner.nextInt();

            for (int i = 0; i < numberOfOperations; i++) {
                String command = scanner.next();

                switch (command) {
                    case "i":
                        int insertPosition = scanner.nextInt();
                        int value = scanner.nextInt();
                        insert_node(insertPosition, value);
                        break;
                    case "d":
                        int deletePosition = scanner.nextInt();
                        delete_node(deletePosition);
                        break;
                    case "p":
                        print_ll();
                        break;
                    default:
                        System.out.println("Unknown command: " + command);
                }
            }
        }
        scanner.close();
    }

    // ==========================================
    // OPTIMIZED API IMPLEMENTATIONS
    // ==========================================

    public static void insert_node(int position, int value) {
        // Guard check using the O(1) list_size variable
        if (position >= 1 && position <= size + 1) {
            Node newNode = new Node(value);

            if (position == 1) {
                // Edge Case: Insert at head
                newNode.next = head;
                head = newNode;
            } else {
                // General Case: Traverse to the node BEFORE the target
                Node previous = head;
                for (int count = 1; count < position - 1; count++) {
                    previous = previous.next;
                }
                // Secure the tail, then update previous
                newNode.next = previous.next;
                previous.next = newNode;
            }

            // Maintain size state (Happens for BOTH head and general cases!)
            size++;
        }
    }

    public static void delete_node(int position) {
        // Guard check using the O(1) list_size variable
        if (position >= 1 && position <= size) {

            if (position == 1) {
                // Edge Case: Delete the head
                head = head.next;
            } else {
                // General Case: Traverse to the node BEFORE the target
                Node previous = head;
                for (int count = 1; count < position - 1; count++) {
                    previous = previous.next;
                }
                // Reroute to skip the target node
                previous.next = previous.next.next;
            }

            // Maintain size state (Happens for BOTH head and general cases!)
            size--;
        }
    }

    public static void print_ll() {
        Node current = head;
        boolean isFirst = true;

        while (current != null) {
            if (isFirst) {
                System.out.print(current.data);
                isFirst = false;
            } else {
                System.out.print(" " + current.data);
            }
            current = current.next;
        }
        System.out.println();
    }
}