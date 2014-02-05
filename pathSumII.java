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
    
    void dfs(TreeNode root,int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if(root==null)
            return ;
        
        path.add(root.val);
        if(root.left==null&&root.right==null){
            if(root.val==sum) {
                ArrayList<Integer> tmp = new ArrayList<Integer>(path);
                result.add(tmp);
            } 
        }

        if(root.left!=null) {
            dfs(root.left,sum - root.val,path,result) ;
        }
        
        if(root.right!=null) {
            dfs(root.right,sum - root.val, path,result);
        }
        path.remove(path.size() - 1);
    }
    
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        dfs(root,sum,path,result);
        return result;
    }
}
