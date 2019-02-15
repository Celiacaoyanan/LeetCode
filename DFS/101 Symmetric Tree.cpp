class Solution {
private:
     bool check_symmetry(TreeNode* left, TreeNode* right) {
         if (left==nullptr && right==nullptr) {
             return true;
         } else if (left==nullptr || right==nullptr) {
             return false;
         } else if (left->val == right->val) {
             return (check_symmetry(left->left, right->right) && check_symmetry(left->right, right->left));
         } else {
             return false;
         }
     }
    
public:
    bool isSymmetric(TreeNode* root) {
        if (root==nullptr) {
            return true;
        }
         return check_symmetry(root->left, root->right);
    }
};
