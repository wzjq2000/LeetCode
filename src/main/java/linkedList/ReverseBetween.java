package linkedList;

import util.ListNode;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left==right) return head;
        ListNode c = head;
        int count = 1;
        ListNode leftNode = c;
        ListNode beforeLeft = null;
        while(c!=null){
            if(count==left){
                leftNode = c;
            }
            if (count==left-1){
                beforeLeft = c;
            }
            if (count==right){
                break;
            }
            c = c.next;
            count++;
        }
        ListNode beyondEnd = c.next;
        ListNode reverse = reverse(leftNode, beyondEnd);
        reverse.next=beyondEnd;

        if (beforeLeft!=null){

            beforeLeft.next = c;
            return head;
        } else {
            return c;
        }



    }

    public ListNode reverse(ListNode head, ListNode beyondEnd){
        if (head.next==beyondEnd){
            return head;
        }
        reverse(head.next, beyondEnd).next = head;
        return head;
    }
}
