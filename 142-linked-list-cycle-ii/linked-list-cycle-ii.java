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

     int length = 0;
     ListNode fast = head;
      ListNode slow = head;
          
          while(fast!=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow ==  fast){
                length = lengthofcycle(slow);
                break;
            }
          }
          if(length == 0){
            return null;
          }

          ListNode s = head;
          ListNode f = head;

          while(length>0){
            s = s.next;
            length--;
          }

          while(s!=f){
            s = s.next;
            f = f.next;
          }
           return s;
    }
    public int lengthofcycle(ListNode slow){
      ListNode temp = slow;
       int length = 0; 

       do{
        temp = temp.next;
        length++;
       }while(temp!=slow);

       return length;
    }
    
}