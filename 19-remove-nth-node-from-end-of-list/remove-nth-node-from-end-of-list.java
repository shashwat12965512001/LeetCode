/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode reverseList(ListNode head){
		ListNode prev = null;
		ListNode curr = head;
		ListNode next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null) {
			return null;
		}else if(head.next.next == null){
			if (n == 1) {
				head.next = null;
				return head;
			}else{
				return head.next;
			}
        }
		ListNode prev = reverseList(head);
		ListNode temp = prev;
		if (n == 1) {
			prev = prev.next;
		}else{
			for (int i = 1; i < n-1; i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
		}
		ListNode result = reverseList(prev);
        return result;
    }
}