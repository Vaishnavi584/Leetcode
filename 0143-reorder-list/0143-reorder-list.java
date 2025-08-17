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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        ListNode mid = middle(head);
        ListNode first = head;
        ListNode second = reverse(mid);
        while(first!=null && second!=null){
            ListNode temp = first.next;
            first.next=second;
            first = temp;
            temp=second.next;
            second.next=first;
            second=temp;
        }
        if(first!=null){
            first.next=null;
        }
    }
    public ListNode middle(ListNode head){
        if(head==null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
         return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode prev =null;
        ListNode pres = head;
        ListNode next= head.next;
        while( pres != null){
         pres.next=prev;
         prev=pres;
         pres=next;
         if(next!=null){
            next=next.next;
         }
        }
       return prev;
    }
}