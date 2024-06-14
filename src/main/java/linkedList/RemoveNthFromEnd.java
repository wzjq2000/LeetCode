package linkedList;

import util.ListNode;

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        helper(dummy, n);
        return dummy.next;


    }
    public static int helper(ListNode head, int target){
        if (head==null){
            return 0;
        }
        int count =  helper(head.next, target)+1;
        if (count<=target){
            return count;
        } else {
            head.next = head.next.next;
            return Integer.MIN_VALUE;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildList(1,2,8,0);

        System.out.println(removeNthFromEnd(head, 1));
    }
}
