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
    public boolean isPalindrome(ListNode head) {
        
        ListNode mid = middle(head);
        ListNode headsec =reverse(mid);
        ListNode rerev = headsec;
        while(head!=null && headsec!=null){
            if(head.val!=headsec.val){
                return false;
            }
            head = head.next;
            headsec=headsec.next;
        }
        reverse(rerev);
        return true;
    }
    public ListNode middle(ListNode head){
          ListNode slow = head;
          ListNode fast = head;
          while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
          }
          return slow;
    }
    public ListNode reverse(ListNode head){
        if(head== null || head.next==null){
            return head;
        }
        ListNode pres =head;
        ListNode prev = null;
        ListNode next = head.next;
        while(pres!=null){
            pres.next=prev;
            prev=pres;
            pres=next;
            if(next!=null){
                next=next.next;
            }
        }
        head=prev;
        return head;
    }
}