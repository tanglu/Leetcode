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
    public int minDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }
        if(root.left==null&&root.right==null) {
            return 1;
        }

        if(root.left!=null&&root.right!=null) {
            return 1 + Math.min(minDepth(root.left),minDepth(root.right));
        } else {
            return 1 + Math.max(minDepth(root.left),minDepth(root.right));
        }
    }
}
