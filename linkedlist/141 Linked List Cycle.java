// if we will use x.next, we must make sure x is not null  //Note: the condition to enter while //fast is ahead of slow, cant set fast=slow=head
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null) return false;
        ListNode fast=head.next; // 
        ListNode slow=head;
                       
        while (fast!=slow) { 
            if (fast==null || fast.next==null) return false; 
            slow=slow.next;
            fast=fast.next.next; // we will use fast.next.next, so we must make sure fast.next is not null       
}
        return true;
    }
}
