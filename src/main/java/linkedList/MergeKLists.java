package linkedList;

import util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public static  ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        ListNode dummy = new ListNode(-1);
        for(ListNode node: lists){
            if (node!=null)
                pq.add(node);
        }
        ListNode cursor = pq.poll();
        dummy.next = cursor;
        while(cursor!=null){
            if(cursor.next!=null) pq.add(cursor.next);
            cursor.next = pq.poll();
            cursor = cursor.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[10];
        mergeKLists(listNodes);
    }
}
