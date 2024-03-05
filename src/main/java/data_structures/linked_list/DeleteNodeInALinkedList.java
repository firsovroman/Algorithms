package data_structures.linked_list;

public class DeleteNodeInALinkedList {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;

        deleteNode(listNode2);

        printList(listNode1);

    }

    public static void deleteNode(ListNode node) {
        ListNode first = node;
        ListNode second = node.next;

        while (second != null) {
            first.val = second.val;

            if(second.next == null) {
                first.next = null;
                break;
            }

            first = first.next;
            second = second.next;
        }

    }


    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

}

