//note: for a node, if left and right are both null, then it is leaf, return 15
//if left is null, but right is not, then set the depth of left to max value, so that it wont //influence to get the min when compared with right
//when calculate depth, remember to add 1
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return getMin(root);
    }
    
    int getMin(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        
        if (node.right == null && node.left == null) {
            return 1;
        }
        
        return Math.min(getMin(node.left), getMin(node.right)) +1 ;
    }
}
