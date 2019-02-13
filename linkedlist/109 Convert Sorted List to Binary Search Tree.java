class Solution {
    ListNode curt; //note curt must be global
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null) return null;
        ListNode current=head;
        curt=head;
        int len=0;
        while (current!=null) {
            len++;
            current=current.next;
        }
        return toBST(len);
    }
    
    public TreeNode toBST(int len) {
        if (len<=0) return null;
        TreeNode left=toBST(len/2);
        TreeNode root=new TreeNode(curt.val);
        curt=curt.next;
        TreeNode right=toBST(len-len/2-1);
        root.left=left;
        root.right=right;
        return root;
    }
}
