

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        public boolean hasCycle(ListNode head) {
        ListNode fast_iter = head;
        ListNode slow_iter = head;
        while (fast_iter!=null && fast_iter.next!=null) {
            slow_iter = slow_iter.next;
            fast_iter = fast_iter.next.next;
            if (fast_iter==slow_iter) {
                return true;
            }
        }
        return false;
        }
    }
}
