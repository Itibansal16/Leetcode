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
    ListNode sorted;
    private void insert(ListNode node){
        if(sorted == null || node.val <= sorted.val){
            node.next = sorted;
            sorted = node;
            return;
        }
        
        ListNode curr = sorted;
        while (curr.next != null && curr.next.val < node.val){ 
            curr = curr.next; 
        }
        
        node.next = curr.next; 
        curr.next = node; 

    }
    
    public ListNode insertionSortList(ListNode head) {
        sorted = null; 
        ListNode curr = head; 
       
        while (curr != null){ 
            ListNode next = curr.next;  
            insert(curr); 
            curr = next; 
        } 

        return sorted; 
    }
}