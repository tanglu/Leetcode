//实际就是遍历一遍树即可，关键是要保证节点能够串起来。Java中无指针，使用数组替代

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
    public void flatten_re(TreeNode root, TreeNode[] current) {
        if(root==null) {
            return;
        }
        TreeNode left  = root.left;
        TreeNode right = root.right;
        if(left!=null) {
            root.left = null;
        }
        current[0].right = root;
        current[0] = root;
        if(left!=null) {
            flatten_re(left,current);
        }
        if(root.right!=null) {
            flatten_re(right,current);
        }
        return;
    }
    
    public void flatten(TreeNode root) {
        if(root==null) {
            return;
        }
        if(root.left==null&&root.right==null) {
            return;
        }
        TreeNode [] array = new TreeNode[1];
        array[0] = root;
        flatten_re(root,array);
        return;
    }
}
