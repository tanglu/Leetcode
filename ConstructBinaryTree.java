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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null&&inorder==null||preorder.length==0) {
            return null;
        }

        TreeNode root     = new TreeNode(preorder[0]);

        int i = 0;
        for(i=0;i<inorder.length;i++) {
            if(inorder[i]==preorder[0]) {
                break;
            }
        }
        
        int[] new_inorder_left, new_preorder_left, new_inorder_right, new_preorder_right;
        
        if(i<inorder.length) {
            //生成左子树时需要用到的inorder
            new_inorder_left = new int[i];
            System.arraycopy(inorder, 0, new_inorder_left, 0, i);
            //生成左子树时需要用到的preorder
            new_preorder_left = new int[i];
            System.arraycopy(preorder, 1, new_preorder_left, 0, i);
            root.left = buildTree(new_preorder_left, new_inorder_left);
            
            //生成右子树时需要用到的inorder
            new_inorder_right = new int[preorder.length - i - 1];
            System.arraycopy(inorder, i + 1, new_inorder_right,  0,  preorder.length - i - 1);
            //生成右子树时需要用到的preorder
            new_preorder_right = new int[preorder.length - i - 1];
            System.arraycopy(preorder, 1 + i, new_preorder_right, 0, preorder.length - i - 1);
            root.right = buildTree(new_preorder_right, new_inorder_right);
        }
        
        return root;
    }
}
