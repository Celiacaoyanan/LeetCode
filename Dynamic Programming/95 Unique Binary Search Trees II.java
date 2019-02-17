class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> r=new ArrayList<>();
        if (n==0) return r;
        return helper(1,n);
    }
    
    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> result=new ArrayList<>();
        if (start>end) {
            result.add(null);
            return result;
        }
        for (int i=start;i<=end;i++) {
            List<TreeNode> left=helper(start,i-1);//left stores all possible left tree
            List<TreeNode> right=helper(i+1,end);//right stores all possible right tree
            for (int j=0;j<left.size();j++) {// 排列组合一下
                for (int k=0;k<right.size();k++) {
                    TreeNode root=new TreeNode(i);//note: the location to initialize root
                    root.left=left.get(j);
                    root.right=right.get(k);
                    result.add(root);
                }
            }
            
        }
        return result;
    }
}
