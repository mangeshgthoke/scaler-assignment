package com.mangesht.practice.java.assignment.class59;

public class Solution_Q1 {

    /**
     * Given a singly linked list, delete middle of the linked list.
     *
     * For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5
     *
     * If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.
     *
     * For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.
     *
     * Return the head of the linked list after removing the middle node.
     *
     * If the input linked list has 1 node, then this node should be deleted and a null node should be returned.
     * @param A
     * @return
     */
    public ListNode solve(ListNode A) {
        ListNode head = A;
        int size = size(A);
        if( size == 1 ) {
            return null;
        }

        int mid = size/2;
        ListNode prev = new ListNode(-1);
        while( mid > 0 && A !=null ) {
            prev = A;
            A = A.next;
            mid--;
        }
        prev.next = A.next;
        return head;
    }

    private int size(ListNode a) {
        int c = 0;
        while( a != null ) {
            c++;
            a = a.next;
        }
        return c;
    }
}
