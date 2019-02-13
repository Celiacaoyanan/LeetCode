//make sure that curt pointer stop before duplicate value, so we compare curt.next and curt.next.next
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy=new ListNode(0);
        ListNode curt=dummy;
        dummy.next=head;
        
        while (curt.next!=null && curt.next.next!=null) {
            if (curt.next.val==curt.next.next.val) {// don't use curt.val==curt.next.val, ensure that curt pointer wont get onto duplicate value
                int v=curt.next.val;
                while (curt.next!=null && curt.next.val==v) {
                    curt.next=curt.next.next;
                }
            } else {
                curt=curt.next;
            }
        }
        
        return dummy.next;
    }
}
