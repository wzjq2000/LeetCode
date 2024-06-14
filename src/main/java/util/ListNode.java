package util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode pointer = this;
        while(pointer!=null){
            sb.append(pointer.val+", ");
            pointer = pointer.next;
        }
        return sb.toString();
    }

    public static ListNode buildList(Integer ...integers){
        ListNode pre=null;
        ListNode head=null;
        for (Integer i: integers){
            ListNode listNode = new ListNode(i);
            if(pre!=null)
                pre.next = listNode;
            else
                head = listNode;
            pre = listNode;
        }
        return head;
    }
}