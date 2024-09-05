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

    public static ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}

		int count = 0;
		for (int i = 0; i < lists.length; i++) {
			ListNode temp = lists[i];
			while (temp != null) {
				count++;
				temp = temp.next;
			}
		}
		if (count == 0) {
			return null;
		}

		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < lists.length; i++) {
			ListNode temp = lists[i];
			Stack<Integer> st = new Stack<>();
			while (temp != null) {
				int num = temp.val;
				if (!s.empty()) {
					while (s.peek() > num) {
						st.push(s.pop());
                        if (s.empty()) {
							break;
						}
					}					
				}
				s.push(num);
				while (!st.empty()) {
					s.push(st.pop());
				}
				temp = temp.next;
			}
		}

		ListNode root = null;
		while (!s.empty()) {
			root = insertAtFirst(root, s.pop());
		}
        return root;
    }
}