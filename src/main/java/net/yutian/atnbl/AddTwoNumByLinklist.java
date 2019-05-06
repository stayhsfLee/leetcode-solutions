/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
package net.yutian.atnbl;

public class AddTwoNumByLinklist {
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
        else if(l1==null&&l2==null){
            //to prevent carry can't be added
            if(carry){
                num++;
                carry=false;
                return new ListNode(num);
            }
            else{
                return null;
            }
        }
        else if(l1==null){
            //to prevent carry can't be added
            if(carry){
                l2.val++;
                if(l2.val>9)
                {
                    l2.val=l2.val-10;
                    l2.next=OneNumCarryForward(l2.next);
                }
            }
            return l2;
        }
        else{
             //to prevent carry can't be added
            if(carry){
                l1.val++;
                if(l1.val>9)
                {
                    l1.val=l1.val-10;
                    l1.next=OneNumCarryForward(l1.next);
                }
            }
            return l1;
        }
        //use iteration to link all nodes together
        ListNode listnode=new ListNode(num);
        listnode.next=addTwoNumbers(l1.next,l2.next);
        return listnode;
    }
    
    public ListNode OneNumCarryForward(ListNode l1)
    {
        if(l1==null){
            if(carry){
                carry=false;
                return new ListNode(1);
            }
            return null;
        }
        else{
            if(carry){
                l1.val++;
                carry=false;
                if(l1.val>9){
                    carry=true;
                    l1.val=l1.val-10;
                    l1.next=OneNumCarryForward(l1.next);
                }
            }
            return l1;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

}