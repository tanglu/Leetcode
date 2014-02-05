public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }
        ListNode tmp = new ListNode(-1);
        tmp.next = null;
        ListNode next;
        ListNode iter;
        ListNode pre;
        while(head!=null) {
            next = head.next;
            pre  = tmp;
            iter = tmp.next;
            while(iter!=null&&iter.val<=head.val) {
                pre  = iter;
                iter = iter.next;
            }
            
            head.next = pre.next; 
            pre.next = head;
            head = next;
        }
        return tmp.next;
    }
}
