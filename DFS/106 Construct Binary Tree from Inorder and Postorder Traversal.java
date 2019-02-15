//similar to 105 
//instart................root...................inend
//poststart......................................postend(root)
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length==0 || postorder.length==0) return null;
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    public TreeNode helper(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        if(instart>inend || poststart>postend) return null;
        TreeNode root=new TreeNode(postorder[postend]);
        int position=findRoot(inorder, instart, inend, postorder[postend]);
        root.right=helper(inorder, position+1, inend, postorder, postend-(inend-position), postend-1);
        root.left=helper(inorder, instart, position-1, postorder, poststart, postend-(inend-position)-1);
        return root;
    }
    
    public int findRoot(int[] inorder, int instart, int inend, int rootVal) {
        for (int i=instart; i<=inend; i++) {
            if (inorder[i]==rootVal) {
                return i;
            }
        }
        return -1;
    }
}
