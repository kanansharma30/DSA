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
    public ListNode reverseEvenLengthGroups(ListNode head) {
       // jo group hai utne elements honge
       // group 1 : 1 node
       // group 2 : 2 nodes and so on
       // agar grp mai even elements hai so usko reverse krdo list mai agar odd hai toh leave it as it is

       ListNode dummy = new ListNode(0);
       dummy.next = head;
       ListNode prevGroupEnd = dummy;
       int groupSize =1;
       while(prevGroupEnd.next != null){
        ListNode groupStart = prevGroupEnd.next;
        ListNode groupEnd = groupStart;
        int aLength =1;
        while(aLength <groupSize && groupEnd.next!= null){
            groupEnd = groupEnd.next;
            aLength++;
        }
        ListNode nextGroup = groupEnd.next;
        if(aLength%2 ==0){
            ListNode prev = nextGroup;
            ListNode curr = groupStart;
            while(curr!= nextGroup){
                ListNode next = curr.next;
                curr.next = prev;
                prev =curr;
                curr=next;
            }

            prevGroupEnd.next = prev;
            prevGroupEnd = groupStart;
        }else{
            prevGroupEnd = groupEnd;

        }
        groupSize++;
       } 
       return dummy.next;
    }
}
