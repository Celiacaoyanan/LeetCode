//for HashMap, each key in a HashMap must be unique. When adding a duplicate key, the old value (for the same key, as keys must be unique) is simply replaced;
//for every root, record its left subtree first, then record its right subtree, in this way, we are always recording its right most node
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if (root==null) return result;
        HashMap<Integer,Integer> map=new HashMap<>();//key is the depth, value is the node.val
        helper(map,1,root);
        
        int depth=1;
        while (map.containsKey(depth)) {
            result.add(map.get(depth));
            depth++;
        }
        return result;
    }
    
    public void helper(HashMap<Integer,Integer> map, int depth, TreeNode root) {
        if (root==null) return;
        map.put(depth,root.val);
        
        helper(map, depth+1, root.left);
        helper(map,depth+1, root.right);
    }
}
