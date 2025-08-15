/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode s= head;
        ListNode f= head;
        int length=0;
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
             ListNode temp= s;
            if(s==f){
              f=head;
              while(f!=s){
                s=s.next;
                f=f.next;
              }
              return s;
            }
        }
       
        return null;
    }
}