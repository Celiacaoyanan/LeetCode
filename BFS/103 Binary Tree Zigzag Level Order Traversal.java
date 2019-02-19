// two stacks, one records the current level nodes, the other records the next level nodes   //two while loop, the outer one make sure all the levels have been traversed, the inner one make sure nodes in every level have been traversed  // in the final step, currLevelNode is empty and nextLevelNode is full, we exchange them to make sure the current is the next, and the next level is empty // must use stack, think about the zigzag shape, the last one in the former level follows by the first one in the next level (20 follows by 15)
class Solution {   
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root==null) {
            return result;
        }
        
        Stack<TreeNode> currLevelNode=new Stack<TreeNode>();
        Stack<TreeNode> nextLevelNode=new Stack<TreeNode>();
        Stack<TreeNode> tmp=new Stack<TreeNode>();
        currLevelNode.push(root);
        boolean currOrder=true;
        while (!currLevelNode.isEmpty()) {
            List<Integer> currLevel=new ArrayList<Integer>();
            
            while (!currLevelNode.isEmpty()) {
                TreeNode head=currLevelNode.pop();
                currLevel.add(head.val);
                if (currOrder==true) {
                    if (head.left!=null) {
                        nextLevelNode.push(head.left);
                    }
                    if (head.right!=null) {
                        nextLevelNode.push(head.right);
                    }                  
                }
                else {
                    if (head.right!=null) {
                        nextLevelNode.push(head.right);
                    }
                    if (head.left!=null) {
                        nextLevelNode.push(head.left);
                    }             
                }
            }
            result.add(currLevel);
            currOrder=!currOrder;
            tmp=currLevelNode;
            currLevelNode=nextLevelNode;
            nextLevelNode=tmp;
        }
        
        
        return result;
    }
}
