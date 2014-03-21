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
    TreeNode mistake1, mistake2;;
    TreeNode pre;
    
    void recursive_traversal(TreeNode root) {
        if(root==null) {
            return;
        }
        if(root.left!=null) {
            recursive_traversal(root.left);
        }
        if(pre!=null&&root.val<pre.val) {
            if(mistake1==null) {
                mistake1 = pre;
                mistake2 = root;
            } else {
                mistake2 = root;
            }
        }
        pre = root;
        if(root.right!=null) {
            recursive_traversal(root.right);
        }
    }
    public void recoverTree(TreeNode root) {
        recursive_traversal(root);
        if(mistake1!=null&&mistake2!=null) {
            int tmp = mistake1.val;
            mistake1.val = mistake2.val;
            mistake2.val = tmp;
        }
    }
}
