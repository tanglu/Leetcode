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
    TreeNode buildTree(int[] num, int begin, int end) {
        
        if(begin==end) {
            TreeNode node = new TreeNode(num[begin]);
            return node;
        } else {
                int mid = begin + (end - begin)/2;
                TreeNode node = new TreeNode(num[mid]);
                if(begin<=(mid-1)) {
                    node.left     = buildTree(num, begin, mid - 1);
                }
                if((mid+1)<=end) {
                    node.right    = buildTree(num, mid + 1, end);
                }
                return node;
        }
        
    }
    
    
    public TreeNode sortedArrayToBST(int[] num) {
        if(num==null||num.length==0) {
            return null;
        }
        return buildTree(num, 0, num.length-1);
    }
}
