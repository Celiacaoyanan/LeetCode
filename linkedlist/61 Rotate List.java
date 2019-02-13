class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next==null) return head;// 0 or 1 node
        for (int i=0; i<k; i++) {
            ListNode last=head;
            while (last.next.next!=null) {
                last=last.next;
            }

            last.next.next=head;
            head=last.next;
            last.next=null;
        }
        return head;        
    }
}
