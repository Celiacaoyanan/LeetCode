// important thought about recursion: when do recursion, we should assume that left and right have already met the requirements
class Solution {
    public void flatten(TreeNode root) {
        if (root==null) return;
        flatten(root.left);
        flatten(root.right);
        
        if (root.left==null) return;
        TreeNode node=root.left;
        while (node.right!=null) {
            node=node.right;
        }
        node.right=root.right;
        root.right=root.left;
        root.left=null;
    }
}
