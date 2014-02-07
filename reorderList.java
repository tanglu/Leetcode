//Given a singly linked list L: L0→L1→…→Ln-1→Ln,
//reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

public class Solution {
    //reverse a linked list
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while(head!=null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    
    public void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null) {
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow will be in the middle
        //reverse the latter list 
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverseList(head2);
        ListNode next2;
        ListNode head1 = head;
        ListNode next1;
        
        //merge the two linked list
        while(head2!=null) {
            next1 = head1.next;
            next2 = head2.next;
            head1.next = head2;
            head2.next = next1;
            head1 = next1;
            head2 = next2;
        }
    }
}
