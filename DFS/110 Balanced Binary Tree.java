//note: if left or right is not balanced, or their depth difference larger than 1, then this node //is not balanced and return -1, otherwise return normal depth
//if one node is not balanced, we record its depth as -1, otherwise we record it as normal depth
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (maxDepth(root) != -1) {
            return true;
        }
        return false;
    } 
    
    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        
        if (left == -1 || right == -1 || Math.abs(left-right)>1) {
            return -1;
        }
        
        return Math.max(left,right)+1;
    }
}
