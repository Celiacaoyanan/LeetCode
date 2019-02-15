class Solution {
private:
    TreeNode* build_tree(vector<int>& nums, int start, int end) {
        if (start>end) return NULL;
        TreeNode* node=new TreeNode(nums[(start+end)/2]);
        node->left=build_tree(nums, start, (start+end)/2-1);
        node->right=build_tree(nums, (start+end)/2+1, end);
        return node;
        
    }
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        if (nums.size()==0) return NULL;
        return build_tree(nums, 0, nums.size()-1);
    }
};
