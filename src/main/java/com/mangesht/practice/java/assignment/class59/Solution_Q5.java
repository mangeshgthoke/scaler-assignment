package com.mangesht.practice.java.assignment.class59;

import java.util.Scanner;

public class Solution_Q5 {
    /**
     * You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.
     *
     * NOTE: You have to do it in-place and in one-pass.
     * @param A
     * @return
     */
    public ListNode reverseList(ListNode A) {
        ListNode previous = null;
        ListNode current = A;
        ListNode tempNode = null;
        while( current !=null ) {
            tempNode = current.next;
            current.next = previous;
            previous = current;
            current = tempNode;
        }
        return previous;
    }
}