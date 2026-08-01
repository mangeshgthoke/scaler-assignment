package com.mangesht.practice.java.assignment.class59;

public class Solution_Q4 {
    /**
     * Reverse a linked list A from position B to C.
     * NOTE: Do it in-place and in one-pass.
     * @param A
     * @return
     */
    public ListNode reverseBetween(ListNode A, int B, int C) {

        ListNode dummy = new ListNode(0);
        dummy.next = A;
        ListNode tempHead = dummy;
        for (int i = 0; i < B - 1; i++) {
            tempHead = tempHead.next;
        }
        ListNode mainPrevious = tempHead;
        ListNode subListStart = tempHead.next;
        ListNode previous = null;
        ListNode current = tempHead;
        ListNode tempNode = null;
        int counter = 0;
        while( current != null && counter < C - B ) {
            tempNode = current.next;
            current.next = previous;
            previous = current;
            current = tempNode;
        }
        mainPrevious.next = previous;
        subListStart.next = current;
        return A;
    }
}