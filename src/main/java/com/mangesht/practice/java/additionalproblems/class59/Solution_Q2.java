package com.mangesht.practice.java.additionalproblems.class59;

import com.mangesht.practice.java.assignment.class59.ListNode;

public class Solution_Q2 {

    /**
     * Given a sorted linked list, delete all duplicates such that each element appears only once.
     * @param A
     * @return
     */
    public ListNode deleteDuplicates(ListNode A) {
        ListNode tempHead = A;
        while( tempHead !=null ) {
            ListNode currentNode = tempHead;
            ListNode nextUniqNode = tempHead.next;
            while( nextUniqNode !=null && currentNode.val == nextUniqNode.val ) {
                nextUniqNode = nextUniqNode.next;
            }
            currentNode.next = nextUniqNode;
            tempHead = currentNode.next;
        }
        return A;
    }
}