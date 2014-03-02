//判断一颗二叉树是否是一个合法的binary search tree
//考虑当前节点左子树的右子树，这个节点需要比它的父亲节点大但要比它的爷爷节点小，所以要新引入一个函数

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
    
    boolean validChild(TreeNode node, int min, int max) {
        if(node==null) {
            return true;
        }
        
        if(node.val>min&&node.val<max) {
            return validChild(node.left,min,node.val)&&validChild(node.right,node.val,max);
        } else {
            return false;
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        if(root==null) {
            return true;
        }
        
        return validChild(root.left,Integer.MIN_VALUE,root.val)&&validChild(root.right,root.val,Integer.MAX_VALUE);
    }
}
