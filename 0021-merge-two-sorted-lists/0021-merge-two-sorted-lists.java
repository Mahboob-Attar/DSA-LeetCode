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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode temp =new ListNode(-1);
        while(list1!=null && list2!=null){
            int val = list1.val;
            int val1 = list2.val;
            if(val<val1){
               temp.next = list1;
               list1 = list1.next; 
            }else{
                  temp.next = list2;
               list2 = list2.next; 
            }

            if(head==null){
                    head = temp.next;
            }
            temp = temp.next;
        }

        while(list1!=null){
            temp.next = list1;
            list1 = list1.next;
            if(head==null){
                    head = temp.next;
            }
             temp = temp.next;
        }
         while(list2!=null){
            temp.next = list2;
            list2 = list2.next;
            if(head==null){
                    head = temp.next;
            }
             temp = temp.next;
        }
        return head;
    }
}