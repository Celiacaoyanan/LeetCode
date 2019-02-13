public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null) return null;
        ListNode slow=head;
        ListNode fast=head.next;
        while (slow!=fast) {
            if (fast==null || fast.next==null) return null;
            slow=slow.next;
            fast=fast.next.next;
        }
        // when get out of while, slow=fast     
        ListNode curt=head;
        while (slow.next!=curt) {// when curt=slow.next, location of curt is the start of the cycle
            slow=slow.next;
            curt=curt.next;
        }
        return curt;        
    }
}
