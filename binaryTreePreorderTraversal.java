//利用Stack非递归前序遍历二叉树
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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(root!=null||!stack.isEmpty()) {
            while(root!=null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = (TreeNode)stack.pop();
            root = root.right;
        }
        return result;
    }
}
