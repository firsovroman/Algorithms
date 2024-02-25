package Data_structures.linked_list;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;


       reverseList(listNode1);

    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    private static void print(ListNode prev, ListNode current, ListNode nextNode) {
        int intPrev = prev != null ? prev.val : 0;
        int intNextNode = nextNode != null ? nextNode.val : 0;
        System.out.println("prev - " + intPrev + ";  current - " + current.val + "; nextNode - " + intNextNode);
    }

}
