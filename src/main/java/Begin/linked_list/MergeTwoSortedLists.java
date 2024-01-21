package Begin.linked_list;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(2);


        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);


        a1.next = a2;
        a2.next = a3;
        a3.next = null;

        b1.next = b2;
        b2.next = b3;
        b3.next = null;

        printList(mergeTwoLists(a1, b1));

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;

        ListNode mock = new ListNode(0);
        ListNode mockhead = mock;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                mock.next = cur1;
                mock = mock.next;
                cur1 = cur1.next;
            } else {
                mock.next = cur2;
                mock = mock.next;
                cur2 = cur2.next;
            }
        }

        if (cur1 == null) {
            mock.next = cur2;
        } else {
            mock.next = cur1;
        }

        return mockhead.next;
    }


    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
