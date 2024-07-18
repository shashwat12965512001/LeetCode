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
    public static ListNode createNode(int val){
		ListNode list = new ListNode();
		list.val = val;
		list.next = null;
		return list;
	}

	public static ListNode insert(ListNode list, int data){
		if (list == null) {
			return createNode(data);
		}
		ListNode newNode = createNode(data);
		ListNode temp = list;
		while (temp.next != null) {
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		return list;
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null) {
			return null;
		}else if (list1 == null) {
			return list2;
		}else if (list2 == null) {
			return list1;
		}

		ListNode list = null;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				list = insert(list, list1.val);
				list1 = list1.next;
			}else{
				list = insert(list, list2.val);
				list2 = list2.next;
			}
		}

		while (list1 != null) {
			list = insert(list, list1.val);
			list1 = list1.next;
		}
		while (list2 != null) {
			list = insert(list, list2.val);
			list2 = list2.next;
		}
		return list;
    }

}