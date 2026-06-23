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

class Solution 
{
    public ListNode removeNthFromEnd(ListNode head, int k) 
    {
        ListNode tail=head;
        int n=0;
        while(tail!=null)
        {
            n++;
            tail=tail.next;
        }
        int remove=n-k;
        if(remove==0)
        {
            return head.next;
        }
        int a=0;

        ListNode prev=null;
        ListNode curr=head;

        while(curr!=null)
        {
            if(a==remove)
            {
                prev.next=curr.next;
                break;
            }
            prev=curr;
            curr=curr.next;
            a++;
        }
        return head;
    }
}
