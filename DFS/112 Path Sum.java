class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null){
            return false;
        }
        
        if (root.left==null && root.right==null){
            return root.val==sum;
        }
        
        if (hasPathSum(root.left, sum-root.val)==true || hasPathSum(root.right, sum-root.val)==true)         {
            return true;
        }
        
        return false;
    }
}
