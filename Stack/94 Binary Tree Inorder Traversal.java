//https://www.youtube.com/watch?v=nzmtCFNae9k
//meet node that doesn’t have left sub tree, pop it and add to result, move to its right sub tree
//meet node that has left sub tree, push it in stack, move to its left sub tree
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if (root==null) return result;
        Stack<TreeNode> s=new Stack<>();
        TreeNode node=root;
        
        while(true) {
            if (node!=null) {
                s.push(node);
                node=node.left;
            } else {
                if (s.isEmpty()) break;
                node=s.pop();
                result.add(node.val);
                node=node.right;
            }
        }
        return result;
    }
}
