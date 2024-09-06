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

    public static ListNode creaListNode(int val) {
		ListNode root = new ListNode();
		root.val = val;
		root.next = null;
		return root;
	}

    public static ListNode insertAtFirst(ListNode root, int val) {
		ListNode newNode = creaListNode(val);
		if (root == null) {
			return newNode;
		}
		newNode.next = root;
		return newNode;
	}

	public static ListNode insertAtLast(ListNode root, int val) {
		ListNode newNode = creaListNode(val);
		if (root == null) {
			return newNode;
		}
		ListNode temp = root;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		return root;
	}

    public static ListNode swapNodes(ListNode head) {
		ListNode first = insertAtFirst(null, head.next.val);
		first.next = creaListNode(head.val);
		return first;
	}

	public static ListNode swapPairs(ListNode head) {
        if (head == null) {
			// No Elements
			return null;
		}else if (head.next == null) {
			// Only 1 Element
			return head;
		}else if (head.next.next == null) {
			// Only 2 Elements
			return swapNodes(head);
		}
		int n = 0;
		ListNode temp = head;
		while (temp != null) {
			temp = temp.next;
			n++;
		}
		Stack<Integer> s = new Stack<>();
		temp = head;
		int size = (n % 2) == 0 ? n : (n-1);
		ListNode root = null;
		for (int i = 0; i < size; i++) {
			if (i > 0 && (i % 2) == 0) {
				while (!s.empty()) {
					root = insertAtLast(root, s.pop());
				}
			}
			s.push(temp.val);
			temp = temp.next;
		}
        while (!s.empty()) {
			root = insertAtLast(root, s.pop());
		}
		if (n % 2 != 0) {
			root = insertAtLast(root, temp.val);
		}
		return root;
    }

}