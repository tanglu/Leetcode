/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
/*
要注意分清返回值和最大值，不能把计算出来的最大值返回回去，否则会有问题。
  1
1   -3
       3

计算到-3节点时，它求出的maxSum(root.left)是3，可以用3更新max，但不能把3返回给1，返回给1的话，会算出最大值为4。
-3节点实际返回给1的是0。
*/ 
public class Solution {
    int max = Integer.MIN_VALUE;
    
    public int maxSum(TreeNode root) {
        if(root==null) {
            return 0;
        }
        
        int  value  = root.val;
        int  lmax = 0;
        int  rmax = 0;
        if(root.left!=null) {
            lmax = maxSum(root.left);
            if(lmax>0) {
            	value  += lmax;
            }
        }
        
        if(root.right!=null) {
            rmax = maxSum(root.right);
            if(rmax>0) {
            	value  += rmax;
            }
        }
        //更新最大值
        //max is the max of {root.val,root.val+lmax,root.val+rmax, root.val + lmax + rmax}
        if (value>max) {
        	max = value;
        }
        //返回值
        //return max of (root.val, root.val + lmax, root.val + rmax)
        return  Math.max(root.val,Math.max(root.val + lmax, root.val + rmax));
    }
    
    public int maxPathSum(TreeNode root) {
        if(root==null) {
            return 0;
        }
        maxSum(root);
        return max;
    }
}
