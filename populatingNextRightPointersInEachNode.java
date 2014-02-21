/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
//hierarchical traverse of binary tree
//make "next" point to the next element
//null is the delimiter of each layer
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue       queue = new LinkedList<TreeLinkNode>();
        
        if(root==null) {
            return;
        }
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            TreeLinkNode current = (TreeLinkNode)queue.poll();
            if(current!=null) {
                current.next = (TreeLinkNode)queue.peek();
                if(current.left!=null) {
                    queue.add(current.left);
                }
                if(current.right!=null) {
                    queue.add(current.right);
                }
            } else {
                if(!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
        
    }
}
