// find mid, reverse second half, link 2 half
class Solution {
    public void reorderList(ListNode head) {
        if (head==null || head.next==null) return;
        
        //find mid location
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode mid=slow;
        
        //reverse second half of the list
        ListNode prev=null;//head2
        ListNode curt=mid.next;
        while (curt!=null) {//note condition to enter while
            ListNode tmp=curt.next;
            curt.next=prev;
            prev=curt;
            curt=tmp;
        }
        ListNode head2=prev;
        mid.next=null;//Note: dont forget this!
        
        //link 2 half list
        ListNode curt1=head;
        ListNode curt2=head2;
        ListNode dummy=new ListNode(0);
        curt=dummy;
        int index=0;
        while (curt1!=null && curt2!=null) {
            if (index%2==0) {
                curt.next=curt1;
                curt1=curt1.next;
            } else {
                curt.next=curt2;
                curt2=curt2.next;
            }
            curt=curt.next;
            index++;            
        }
        
        if (curt1!=null) {
            curt.next=curt1;
        }
        if (curt2!=null) {
            curt.next=curt2;
        }
        
    }
