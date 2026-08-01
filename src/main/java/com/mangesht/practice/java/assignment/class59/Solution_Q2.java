package com.mangesht.practice.java.assignment.class59;

import java.util.List;

public class Solution_Q2 {

    public ListNode reverseList(ListNode A, int B) {
        ListNode tempHead = A;
        int start = 1;
        int end = B;
        int size = 0;

        while( tempHead != null ) {
            tempHead = tempHead.next;
            size++;
        }
        int reverseCounter = size/B;

        tempHead = A;
        while( reverseCounter > 0 ) {
            A = reverseBetween(A, start, end);
            start = end + 1;
            end = end + B;
            reverseCounter--;
        }
        return A;
    }
    /**
     * Reverse a linked list A from position B to C.
     * NOTE: Do it in-place and in one-pass.
     * @param A
     * @return
     */
    public ListNode reverseBetween(ListNode A, int B, int C) {

        if (A == null || B == C) {
            return A;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = A;
        ListNode tempHead = dummy;
        for (int i = 0; i < B - 1; i++) {
            tempHead = tempHead.next;
        }
        ListNode mainPrevious = tempHead;
        ListNode subListStart = tempHead.next;
        ListNode previous = null;
        ListNode current = subListStart;
        ListNode tempNode = null;
        for( int counter = 0; counter <= C - B; counter++ ) {
            tempNode = current.next;
            current.next = previous;
            previous = current;
            current = tempNode;
        }
        mainPrevious.next = previous;
        subListStart.next = current;
        return dummy.next;
    }
}