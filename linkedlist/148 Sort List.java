//merge sort
//find mid, get 2 lists, sort 2 lists recursively, merge 2 sorted lists
class Solution {
    //find mid
    public ListNode findMid(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy=new ListNode(0);
        ListNode curt=dummy;
        while (head1!=null && head2!=null) {
            if (head1.val<head2.val) {
                curt.next=head1;
                head1=head1.next;
            } else {
                curt.next=head2;
                head2=head2.next;
            }
            curt=curt.next;//note:dont forget this 
        }
        if (head1!=null) {
            curt.next=head1;
        } 
        if (head2!=null) {
            curt.next=head2;
        }
        return dummy.next;
    }
    
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) return head;
        
        //find mid
        ListNode mid=findMid(head);
        
        //sort 2 parts recursively
        // note:must use mid to sort right part first, then set left part's last node(mid.next) to be null, then sort left part. cant use mid to be the head of right part, because we need use the node before mid
        ListNode right=sortList(mid.next);
        mid.next=null;
        ListNode left=sortList(head);

        //merge 2 parts
        return merge(left, right);  
    }
}
