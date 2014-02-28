//判断一个二叉树是否为平衡二叉树
//递归求出左子树和右子树的高度，然后判断其值是否相差1

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int treeDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int leftDepth  = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return Math.max(leftDepth + 1, rightDepth + 1);
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)) {
            return true;
        }
        int leftDep   = treeDepth(root.left);
        int rightDep  = treeDepth(root.right);
        int tmp = leftDep - rightDep;
        return ((tmp>=-1&&tmp<=1)&&isBalanced(root.left)&&isBalanced(root.right));
        
    }
}
