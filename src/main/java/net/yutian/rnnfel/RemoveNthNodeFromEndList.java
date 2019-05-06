package net.yutian.rnnfel;

import java.util.LinkedList;

/**
 * Created by LeeAutumn on 19/12/2016.
 * blog: leeautumn.net
 */
public class RemoveNthNodeFromEndList {



    //有两种方法,
    // 第一种方法使用List来表示滑动窗格
    // 第二种方法,使用 head和tail 两个int数字 以及相应的两个node指针来表示滑动窗格

    /**
     * 1. 类似于滑动窗格,从左往右滑动,长度为n+1.
     * @param head
     * @param n         n >= 1
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = head;


        LinkedList<ListNode> list = new LinkedList<>();

        while(head!= null){
            list.add(head);

            if(list.size() > n+1){
                list.remove();
            }

            head = head.next;
        }

        while(list.size() < n+1){
            list.addFirst(null);
        }

        ListNode before  = list.pollFirst();
        ListNode removed = list.pollFirst();
        ListNode after   = list.pollFirst();

        if(before != null) {
            before.next = after;

            return h;
        }else {
            //此时 list的队列长度<=2 因为没有填满queue
            //此时要被删除的 head

            //To-Do : 做好头指针删除操作

            //返回新的头指针
            return after;
        }


    }
}

