// recursion + divide&conquer
//return type is ListList not ArrayListArrayList
//when new, use ArrayList
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path=new ArrayList<Integer>();      
        findPath(result,path,root,sum);
        
        return result;
    }
    
    public void findPath(List<List<Integer>> result, ArrayList<Integer> path, TreeNode root, int sum) {
        if (root==null) {
            return;
        }
        
        sum-=root.val;
        if (root.left==null && root.right==null) {// when it is leaf node && sum is exactly the sum 
            if (sum==0) {
                path.add(root.val);//add this leaf node
                result.add(new ArrayList<Integer>(path));//one path found
                path.remove(path.size()-1);//remove this leaf node, check whether there is another node+previous nodes=sum
            }
            return;
        }
        
        path.add(root.val);
        findPath(result, path, root.left, sum);
        findPath(result, path, root.right, sum);
        path.remove(path.size()-1); //recursion, undo what is done before recursion
    }
}
