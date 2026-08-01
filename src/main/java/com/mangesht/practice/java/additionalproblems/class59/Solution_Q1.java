package com.mangesht.practice.java.additionalproblems.class59;

import com.mangesht.practice.java.assignment.class59.ListNode;

public class Solution_Q1 {

    /**
     * Given a linked list A, remove the B-th node from the end of the list and return its head.
     * For example, given linked list: 1->2->3->4->5, and B = 2.
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     *
     * NOTE: If B is greater than the size of the list, remove the first node of the list.
     *
     * Try doing it using constant additional space.
     * @param A
     * @param B
     * @return
     */


    public ListNode removeNthFromEnd(ListNode A, int B) {
        int size = size(A);
        if( size == 1 && B >= 1) {
            return null;
        }
        int position = size - B + 1;
        if( B > size ) {
            position = 1;
        }
        return delete_node(A, size, position);
    }

    private ListNode delete_node(ListNode A, int size, int position) {
        // Guard check using the O(1) list_size variable
        ListNode head = A;
        if (position >= 1 && position <= size) {

            if (position == 1) {
                // Edge Case: Delete the head
                head = head.next;
            } else {
                // General Case: Traverse to the node BEFORE the target
                ListNode previous = head;
                for (int count = 1; count < position - 1; count++) {
                    previous = previous.next;
                }
                // Reroute to skip the target node
                previous.next = previous.next.next;
            }
        }
        return head;
    }
    private int size(ListNode a) {
        int c = 0;
        while( a != null ) {
            c++;
            a = a.next;
        }
        // System.out.println(c);
        return c;
    }
}
