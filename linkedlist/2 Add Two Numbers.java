// if the lengths are not equal, use while in the later two loop, not if!
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if (l1==null && l2==null) return null;
        ListNode dummy=new ListNode(0);
        ListNode curt=dummy;
        int carry=0;
        while (l1!=null && l2!=null) {
            int sum=carry+l1.val+l2.val;
            curt.next=new ListNode(sum%10);
            carry=sum/10;
            l1=l1.next;
            l2=l2.next;
            curt=curt.next;
        }
        
        while (l1!=null) {
            int sum=carry+l1.val;
            curt.next=new ListNode(sum%10);
            carry=sum/10;
            l1=l1.next;
            curt=curt.next;
        }
        
        while (l2!=null) {
            int sum=carry+l2.val;
            curt.next=new ListNode(sum%10);
            carry=sum/10;
            l2=l2.next;
            curt=curt.next;
        }
        
        if (carry!=0) {//if there is carry in the last digit
            curt.next=new ListNode(carry);
        }
        
        return dummy.next;

    }
}
