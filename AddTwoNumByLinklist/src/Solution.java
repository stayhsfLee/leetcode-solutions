/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    boolean carry=false;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //nnum--the val in the every node
        int num=0;
        if(l1!=null&&l2!=null){
            num=l1.val+l2.val;
            if(carry){
                num++;
            }
            if(num>9){
                carry=true;
                //to prevent each val in node greater than 10  e.g. 6->11(error)->8
                num=num-10;
            }
            else{
                carry=false; 
            }
        }
        else if(l1==null){
            return l2;
        }
        else if(l2==null){
            return l1;
        }
        else{
            return null;
        }
        
        //use iteration to link all nodes together
        ListNode listnode=new ListNode(num);
        listnode.next=addTwoNumbers(l1.next,l2.next);
        return listnode;
    }
}