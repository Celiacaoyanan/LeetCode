// two pointers, left pointer connect nodes that are smaller than x, right pointer connect nodes that are greater than or equal to x, then we get two inkedlists, finally we link 2 linkedlists
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head==null) return head;
        ListNode leftdummy=new ListNode(0);
        ListNode rightdummy=new ListNode(0);
        ListNode left=leftdummy, right=rightdummy;
        ListNode curt=head;
        while (curt!=null) {
            if (curt.val<x) {
                left.next=curt;
                left=left.next;
            } else {
                right.next=curt;
                right=right.next;
            }
            curt=curt.next;
        }
        
        left.next=rightdummy.next;
        right.next=null;
        return leftdummy.next;
    }
}
