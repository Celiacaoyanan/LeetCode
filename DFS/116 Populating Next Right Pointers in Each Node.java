//level traverse, use null to mark the end of one level
class Solution {
    public Node connect(Node root) {
        if (root==null) return null;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            Node n=queue.poll();
            if (n!=null) {
                n.next=queue.peek();
                
                if (n.left!=null) queue.offer(n.left);
                if (n.right!=null) queue.offer(n.right);
            } else { // if meet null, means we have visited all nodes in one level (eg level 3), and have already put all children(level 3) of this level in queue, so put a null to mark end of level 3
                if (!queue.isEmpty()) { // deal with the last null, otherwise queue will never be empty
                    queue.offer(null);
                }
            }
            
        }
        return root;
    }
}
