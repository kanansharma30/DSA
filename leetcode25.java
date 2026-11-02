/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //creating a dummy node
        ListNode dummy = new ListNode(0);
        // the new node with value 0 is not a part of answer it is just a helper node
        //which is connected to the original first node
        dummy.next = head;
        // creaters a pointer called groupPrev that starts at the dummy node
        // this groupPrev will always help us find the node immediately before the group we are about to reverse
        ListNode groupPrev = dummy;
        while (true) {
            // 
            ListNode kth = groupPrev;
            for (int i = 0; i < k; i++) {
                kth = kth.next;
                // we check this because, sometimes fewer than k nodes remain.If this happens, we return the list without reversing those remaining nodes
                // the kth tells where the current group ends 
                if (kth == null) {
                    return dummy.next;
                }
            }

            // next: Temporarily stores the next node so we dont lose access to the unreversed part of the list.
            ListNode groupNext = kth.next; // yeh first node hai outside the group, we need it to know where we need to stop reversing
            ListNode prev = groupNext; // the node that curr should point to when its link is reversed
            ListNode curr = groupPrev.next; // the nodes whose next link we will chaneg
            while (curr != groupNext) {
                ListNode next = curr.next; // to remember kahan jana hai before changing the link
                curr.next = prev; // makes the current node point abckward instead of forward
                prev = curr; // current node previous ban jayega next iteration ke liye
                curr = next; // continue to node we saved earlier
            }
            ListNode OldGroupStart = groupPrev.next; // saves the original first node of the group 
            groupPrev.next = kth; // connects krega previous part of list to new list node of the reversed group
            groupPrev = OldGroupStart; // moves groupPRev to end of reversed grp, to use it in next group

        }
    }
}
