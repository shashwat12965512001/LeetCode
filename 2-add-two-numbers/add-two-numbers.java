import java.math.BigInteger;

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
    public static BigInteger listToNum(ListNode li) {
        StringBuilder sb = new StringBuilder();
        while (li != null) {
            sb.append(li.val);
            li = li.next;
        }
        BigInteger num = new BigInteger(sb.reverse().toString());
        return num;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1 = listToNum(l1);
        BigInteger num2 = listToNum(l2);
        num1 = num1.add(num2);
        ListNode head = new ListNode();
        ListNode result = new ListNode();
        head = result;
        while (!num1.equals(BigInteger.ZERO)) {
            result.val = Integer.parseInt(String.valueOf(num1.mod(BigInteger.TEN)));
            num1 = num1.divide(BigInteger.TEN);
            if (!num1.equals(BigInteger.ZERO)) {
                result.next = new ListNode();
                result = result.next;
            }
        }
        return head;
    }
}