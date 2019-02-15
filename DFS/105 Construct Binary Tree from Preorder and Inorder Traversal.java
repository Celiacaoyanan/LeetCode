// root is in the first position in preorder, use this root value to find the root position in inorder, from (instart to root position) is the inorder of left tree, and we can get the size of left tree, and use this size we can get the range of left tree in preorder, which is (prestart to location-instart+prestart). Then the range of right tree in preorder is (location-instart+prestar+1 to preend), the range of right tree in inorder is (location+1 to inend)
// root(prestart)....................................................preend
//instart...................................root.......................inend
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0 || inorder.length==0) return null;
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode helper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (prestart > preend || instart>inend) return null;// note: the condition to get out of recursion

        TreeNode root=new TreeNode(preorder[prestart]);
        int location=findRoot(inorder, instart, inend, preorder[prestart]);
        root.left=helper(preorder, prestart+1, location-instart+prestart, inorder, instart, location-1);
        root.right=helper(preorder, location-instart+prestart+1, preend, inorder, location+1, inend);
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
