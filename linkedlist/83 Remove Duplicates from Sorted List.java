/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode curt=head;
        while (curt.next!=null) { //note the condition to get into while, judge curt.next not curt
            if (curt.val==curt.next.val) {
                curt.next=curt.next.next; // if found, curt doesn’t move
            } else {
                curt=curt.next;
            }
        }
        return head;
    }
}
