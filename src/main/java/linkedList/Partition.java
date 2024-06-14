package linkedList;

import util.ListNode;

public class Partition {
    public static ListNode partition(ListNode head, int x) {
        ListNode biggerOrEqual = null;
        ListNode smaller = null;
        ListNode realHead = null;
        ListNode biggerOrEqualHead = null;

        while (head != null) {
            if (head.val < x) {
                if (smaller == null) {
                    smaller = head;
                    realHead = head;
                } else {
                    smaller.next = head;
                    smaller = head;
                }
            } else {
                if (biggerOrEqual == null) {
                    biggerOrEqual = head;
                    biggerOrEqualHead = head;

                } else {
                    biggerOrEqual.next = head;
                    biggerOrEqual = head;
                }
            }
            head = head.next;
        }
        if (smaller != null) {
            smaller.next = biggerOrEqualHead;
        } else {
            realHead = biggerOrEqualHead;
        }
        if (biggerOrEqual != null) {
            biggerOrEqual.next = null;
        }
        return realHead;

    }


}
