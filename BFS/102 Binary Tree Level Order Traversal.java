// Note which store Integer and which store TreeNode  //how to Initiate List result=new ArrayList<Integer>(); // Use LinkedList to Initiate queue // offer(push in)/poll(get and delete)

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>(); //note
        if (root==null) {
            return result;
        }
        
        Queue<TreeNode> queue=new LinkedList<TreeNode>(); //note
        queue.offer(root);        
        while (!queue.isEmpty()) {
            List<Integer> level=new ArrayList<Integer>(); //note
            int size=queue.size(); //must use an int to record the size, bacause later new element might be added in the queue and size might change

            for (int i=0;i<size;i++) {
                TreeNode head=queue.poll();
                level.add(head.val);// add the value not treenode
                if (head.left!=null) {
                    queue.offer(head.left);
                }
                if (head.right!=null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        } 
        return result;
    }
}
