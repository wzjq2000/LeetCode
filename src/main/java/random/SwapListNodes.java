package random;

public class SwapListNodes {
    public static ListNode swapPairs(ListNode head) {
        ListNode temp=null;
        ListNode result=null;

        while (head != null && head.next != null) {
            if(temp!=null){
                temp.next = head.next;
                temp = head.next;
            } else {
                temp = head.next;
                result = temp;
            }
            head.next = temp.next;
            temp.next = head;
            temp = head;
            head = head.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.buildList(1, 2, 3, 4,5);
        System.out.println(listNode);
        ListNode listNode1 = swapPairs(listNode);
        System.out.println(listNode1);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
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
