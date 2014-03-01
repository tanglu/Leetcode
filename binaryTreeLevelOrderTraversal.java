//层次遍历二叉树，同时要按层次输出节点内容
//通过每层结束的时候加入NULL来控制换行

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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> elem = new ArrayList<Integer>();
        if(root==null) {
            return ret;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        
        while(!queue.isEmpty()) {
            root = (TreeNode)queue.poll();
            if(root!=null) {
                elem.add(root.val);
                if(root.left!=null) {
                    queue.add(root.left);
                }
                if(root.right!=null) {
                    queue.add(root.right);
                }
            } else {
                ArrayList<Integer> tmp = new ArrayList<Integer>(elem);
                ret.add(tmp);
                elem.clear();
                if(!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
        return ret;
    }
}
