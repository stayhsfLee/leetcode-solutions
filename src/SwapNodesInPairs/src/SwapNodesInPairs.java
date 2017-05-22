package SwapNodesInPairs.src;

/**
 * Created by Moopa on 22/05/2017.
 * blog: leeautumn.net
 *
 * @autuor : Moopa
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next ==null){
            return head;
        }

        int i=1;

        ListNode temp = head;
        head = head.next;
        ListNode temptail = null;

        while(temp != null){
            ListNode first = temp;
            ListNode second = temp.next;

            if(second == null){
                break;
            }
            ListNode third = second.next;

            //先把first和second调换
            second.next = first;
            //连接第三个
            first.next = third;
            //修改和前端的链接
            if(temptail != null){
                temptail.next = second;
                temptail = first;
            }

            temp = third;
        }


        return head;
    }
}

class ListNode {
int val;
ListNode next;
ListNode(int x) { val = x; }
}
