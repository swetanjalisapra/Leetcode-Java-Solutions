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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
           if(l1==null&&l2==null){
            return l1;
        }
         if(l1==null&&l2!=null){
            return l2;
        }
         if(l1!=null&&l2==null){
            return l1;
        }
       
      	ListNode h,t;
        if(l1.val<l2.val){
            h=l1;
            t=l1;
            l1=l1.next;
        }
        else
        {
            h=l2;
            t=l2;
            l2=l2.next;
        }
        while(l1!=null&&l2!=null)
        {
            if(l1.val<l2.val)
            {
                t.next=l1;
                t=t.next;
                l1=l1.next;
            }
            else
            {
                t.next=l2;
                t=t.next;
               l2=l2.next;
            } 
        }
        if(l1!=null)
        {
            t.next=l1;
        }
        if(l2!=null)
        {
            t.next=l2;
        }

        return h;  
    }
}