class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }    
    public int helper(TreeNode root, int prevSum) {
        if (root==null) return 0;
        int sum=root.val+prevSum*10;
        if (root.left==null && root.right==null) return sum;
        return helper(root.left, sum)+helper(root.right, sum);
    }
}
