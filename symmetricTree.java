//recursion to check symmetric tree

public class Solution {
    public boolean childIsSymmetric(TreeNode left, TreeNode right) {
        if(left==null&&right==null) {
            return true;
        }
        if(left==null || right==null) {
            return false;
        }
        
        return left.val==right.val&&childIsSymmetric(left.left,right.right)&&childIsSymmetric(left.right,right.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        if(root==null) {
            return true;
        }
        return childIsSymmetric(root.left,root.right);
    }
}
