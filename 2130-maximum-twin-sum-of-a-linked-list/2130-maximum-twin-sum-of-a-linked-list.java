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
//find the middle using slow and fast
//reverse the second half
//traverse simultaneously to find sum of twin and then max

class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
//finding middle
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
//reverse the second half
        ListNode prev = null, curr = slow;
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
//prev is now the head of reversed second half
        ListNode first = head;
        ListNode second = prev;

        int max = 0;
        while(second != null){
            max = Math.max(max, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        return max;
    }
}