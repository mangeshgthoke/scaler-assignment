package com.mangesht.practice.java.assignment.class59;

public class Solution_Q3 {

    /**
     * Given a linked list of integers, find and return the middle element of the linked list.
     *
     *
     *
     * NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.
     * @param A
     * @return
     */


    public int solve(ListNode A) {
        ListNode tempHead = A;
        int size = size(A);
        int mid = size / 2;

        while (mid > 0 && tempHead != null) {
            tempHead = tempHead.next;
            mid--;
        }

        return tempHead.val;
    }

    private int size(ListNode a) {
        int c = 0;
        while (a != null) {
            c++;
            a = a.next;
        }
        return c;
    }
}
