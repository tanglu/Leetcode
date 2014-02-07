public class Solution {
    //Merge sort for a List
    //time complexity: O(nlog(n))
    ListNode getMiddleOfList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }
    	ListNode middle = getMiddleOfList(head);
    	ListNode next   = middle.next;
    	    middle.next = null;
    	return mergeList(sortList(head), sortList(next));
    }
    
    ListNode mergeList(ListNode a, ListNode b) {
    	ListNode dummyHead = new ListNode(-1);
    	ListNode curr = dummyHead;
    	while(a!=null&&b!=null) {
    		if(a.val<=b.val) {
    			curr.next=a;a=a.next;
    		} else {
    			curr.next=b;b=b.next;
    		}
    		curr  = curr.next;
    	}
    	curr.next = a!=null?a:b;
    	return dummyHead.next;
    }
}
