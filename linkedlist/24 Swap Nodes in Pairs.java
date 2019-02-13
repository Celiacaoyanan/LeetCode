class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head==null) return null;// zero node
        if (head.next==null) return head;// one node
        
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode curt1=head;
        ListNode curt2=head.next;
        ListNode nex=head.next.next;
        while (true) {
            curt2.next=curt1;
            prev.next=curt2;
            curt1.next=nex;
                  
            if (nex!=null && nex.next!=null) {
                prev=curt1;
                curt1=nex;
                curt2=nex.next;
                nex=nex.next.next;
            } else {
                break;
            }

        }
        
        return dummy.next;       
    }
}
