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
        ListNode fast_iter = head;
        ListNode slow_iter = head;
        while (fast_iter!=null && slow_iter!=null) {
            ListNode temp = fast_iter.next;
            if(temp==null) {
                return false;
            }
            fast_iter = temp.next;
            slow_iter = slow_iter.next;
            if (fast_iter==slow_iter) {
                break;
            }
        }
        if(fast_iter!=null&&fast_iter==slow_iter) {
            return true;
        }
        return false;
    }
}
