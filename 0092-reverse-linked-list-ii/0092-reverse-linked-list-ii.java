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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }
        ListNode prev=null;
        ListNode pres=head;
        for(int i=0;i<left-1 && pres!=null;i++){
            prev=pres;
            pres=pres.next;
        }
        ListNode last = prev ;
        ListNode newend= pres;
        ListNode next = pres.next;
         for(int i=0 ;i<right-left+1 && pres!=null ; i++){
            pres.next =prev;
            prev=pres;
            pres=next;
            if(next!=null){
                next=next.next;
            }
         }
         if(last!=null){
              last.next=prev;
         }
         else{
            head=prev;
         }

         newend.next=pres;
        return head;
    }
}