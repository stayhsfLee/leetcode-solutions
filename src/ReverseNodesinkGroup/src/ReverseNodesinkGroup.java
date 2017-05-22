package ReverseNodesinkGroup.src;

/**
 * Created by Moopa on 22/05/2017.
 * blog: leeautumn.net
 *
 * @autuor : Moopa
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return head;
        }

        ListNode[] ls = new ListNode[k];
        ListNode temp = head;
        ListNode nextFirst = null;
        int result = 0;
        while((result = putNodeIntoArray(ls,temp,k)) != -1 ){
            if(nextFirst == null){
                head = ls[0];
            }
            nextFirst = ls[0].next;
            for(int i=0;i<k-1;i++){
                ls[i].next = ls[i+1];
            }

            ls[k-1].next = nextFirst;
            temp = nextFirst;
        }

        return head;
    }

    public int putNodeIntoArray(ListNode[] array,ListNode first,int k){
        if(first == null){
            return -1;
        }

        while(k!=0){
            array[k-1] = first;
            k--;

            first = first.next;
            if(first == null && k!= 0){
                return -1;
            }
        }

        return 1;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}