//Note: the use of Collections.reverse(list), return value is void, directly change list 
//Or traverse from the last element to the first one, and use another list to record it
// for (int i=size-1;i>=0;i--)  list2.add(list1.get(i))
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List result=new ArrayList<Integer>(); // Note
        if (root==null) {
            return result;
        }
        
        Queue<TreeNode> queue=new LinkedList<TreeNode>(); // how to use queue
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            List<Integer> level=new ArrayList<Integer>();
            int size=queue.size();
            for (int i=0;i<size;i++) {
                TreeNode head=queue.poll();
                level.add(head.val);
                if (head.left!=null) { 
                    queue.offer(head.left);
                }
                if (head.right!=null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        } 
        Collections.reverse(result);
        return result;        
    }
}
