package linkedList;


import util.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode result = null;
        ListNode head = null;
        while (node1!= null && node2!= null) {
            ListNode temp;
            if (node1.val < node2.val) {
                temp = new ListNode(node1.val);
                node1 = node1.next;
            } else {
                temp = new ListNode(node2.val);
                node2 = node2.next;
            }
            if (head!=null){
                head.next = temp;
            } else {
                result = temp;
            }
            head = temp;
        }

        while(node1!=null){
            if(head==null){
                head = new ListNode(node1.val);
                result = head;
            } else {
                head.next = new ListNode(node1.val);;
                head = head.next;
            }
            node1 = node1.next;
        }

        while(node2!=null){
            if(head==null){
                head = new ListNode(node2.val);
                result = head;
            } else {
                head.next = new ListNode(node2.val);;
                head = head.next;
            }
            node2 = node2.next;
        }

        return result;
    }
}

