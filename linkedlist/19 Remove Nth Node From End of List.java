// Could you do this in one pass? //使用两个指针扫描，当第一个指针扫描到第N个结点后， 第二个指针从表头与第一个指针同时向后移动， 当第一个指针指向空节点时，另一个指针就指向倒数第n个结点了 // nth from the back means (len-n)th from the front, the above method make sure to find the (len-n)th from the front 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null) return null;
        
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curt=head;
        int len=1;
        while (curt.next!=null) {
            curt=curt.next;
            len++;
        }
        if (n==len) return head.next;
        curt=head;
        for (int i=1;i<len-n;i++) {
            curt=curt.next;
        }
        curt.next=curt.next.next;
        
        return head;
    }
}
