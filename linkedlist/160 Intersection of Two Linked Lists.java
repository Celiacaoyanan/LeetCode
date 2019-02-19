//link them together and find the entry node of circle, turn into 142
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null) return null;
        
        //link 2 lists
        ListNode curt=headA;// if headA==null return null, wont operate the following steps
        while (curt.next!=null) {
            curt=curt.next;
        }
        curt.next=headB;
        
        ListNode head=headA;
        ListNode slow=headA;
        ListNode fast=headA.next;
        while (slow!=fast) {
            if (fast==null || fast.next==null) {
                curt.next=null;
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        
        while(head!=slow.next) {
            head=head.next;
            slow=slow.next;
        }
        curt.next=null;//recover 2 lists
        return head;
    }
}
