public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode next = head.next;
        while(next!=null) {
            if(head.val!=next.val) {
                head = head.next;
            } else {
                head.next = next.next;
            }
            next = next.next;
        }
        return dummy.next;
    }
}
