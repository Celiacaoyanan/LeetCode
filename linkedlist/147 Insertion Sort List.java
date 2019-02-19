//2 lists, one list is the original list, the other one is the new list with head dummy, traverse all the node in the old list, and insert it at the right location in the new list //for every node in the original lists, we find the first one that is larger than it in the new list (assume it as A), but we need the node that is before A, so we let curt=the node before A, let curt.next=A, 
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=null;
        while (head!=null) {
            ListNode curt=dummy;
            while (curt.next!=null && curt.next.val<head.val) {//evaluate curt.next not curt
                curt=curt.next;
            }
            ListNode tmp=head.next;
            head.next=curt.next;
            curt.next=head;          
            head=tmp;
        }
        return dummy.next;     
    }
}
