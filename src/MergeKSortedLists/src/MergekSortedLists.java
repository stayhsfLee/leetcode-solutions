package MergeKSortedLists.src;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Moopa on 21/05/2017.
 * blog: leeautumn.net
 *
 * @autuor : Moopa
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode tail = null;

        //清理掉为空的捣乱listnode
//        for(int i=0;i<lists.length;i++){
//            if(lists[i] == null){
//                ListNode[] ls = new ListNode[lists.length - 1];
//                int k=0;
//                for (int j = 0; j < lists.length; j++) {
//                    if (j != i) {
//                        ls[k] = lists[j];
//                        k++;
//                    }
//                }
//                lists = ls;
//                i--;
//            }
//        }

        if(lists == null || lists.length == 0){
            return null;
        }

        for (; ; ) {
            int temp = -1;
            for (int i = 0; i < lists.length; i++) {
                if(lists[i] == null){
                    continue;
                }
                if(temp == -1){
                    temp = i;
                    continue;
                }
                if (lists[i].val < lists[temp].val) {
                    temp = i;
                }
            }

            if (temp == -1){
                break;
            }
            if (head == null) {
                head = lists[temp];
                tail = lists[temp];
            }else {

                tail.next = lists[temp];
                tail = tail.next;
            }

            lists[temp] = lists[temp].next;

//            if (lists[temp].next == null) {
//                //将这一段清除出lists
//                if (lists.length == 1) {
//                    break;
//                }
//                ListNode[] ls = new ListNode[lists.length - 1];
//                int j = 0;
//                for (int i = 0; i < lists.length; i++) {
//                    if (i != temp) {
//                        ls[j] = lists[i];
//                        j++;
//                    }
//                }
//
//                lists = ls;
//                // end
//            }else {
//                lists[temp] = lists[temp].next;
//            }
        }


        return head;
    }

    public ListNode mergeKLists2(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return null;
        }

        if(lists.length == 1){
            return lists[0];
        }

        boolean n = lists.length % 2 == 0;

        ListNode[] ls = new ListNode[n ? lists.length/2:lists.length/2+1];

        for(int i=0;i< (n?ls.length:ls.length-1);i++){
            ls[i] = mergeTwoSortedList(lists[i*2],lists[i*2+1]);
        }

        if(!n){
            ls[ls.length-1] = lists[lists.length-1];
        }

        return mergeKLists2(ls);

    }

    public ListNode mergeTwoSortedList(ListNode one,ListNode two){
        if(one == null){
            return two;
        }
        if(two == null){
            return one;
        }
        boolean isOne = one.val <= two.val;

        ListNode head = isOne?one:two;
        ListNode tail = head;

        if(isOne){
            one = one.next;
        }else{
            two = two.next;
        }

        while(one != null && two != null){
            isOne = one.val <= two.val;

            //找到小的那一段
            if(isOne){
                tail.next = one;
                ListNode before = one;
                while(one.val <= two.val){
                    before = one;
                    one = one.next;
                    if(one == null){
                        break;
                    }
                }
                tail = before;
            }else {
                tail.next = two;
                ListNode before = two;
                while(two.val <= one.val){
                    before = two;
                    two = two.next;
                    if(two == null){
                        break;
                    }
                }
                tail = before;
            }
        }

        if(one == null){
            if(two != null){
                tail.next = two;
            }
        }

        if (two == null) {
            tail.next = one;
        }

        return head;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}