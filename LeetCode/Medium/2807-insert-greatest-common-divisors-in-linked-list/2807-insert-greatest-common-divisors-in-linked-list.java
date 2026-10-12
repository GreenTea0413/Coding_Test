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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;

        while(cur != null && cur.next != null){
            int num = gcd(cur.val, cur.next.val);

            ListNode newNode = new ListNode(num);
            newNode.next = cur.next;
            cur.next = newNode;

            cur = newNode.next;
        }
        return head;
    }

    int gcd(int a, int b){
        return (b != 0) ? gcd(b, a % b): a;
    }
}