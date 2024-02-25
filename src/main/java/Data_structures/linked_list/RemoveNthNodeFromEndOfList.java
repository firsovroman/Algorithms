package Data_structures.linked_list;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);

        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);


        a1.next = a2;
        a2.next = a3;

        a3.next = a4;
        a4.next = a5;
        a5.next = null;


        ListNode result = removeNthFromEnd(a1, 5);

        System.out.println(result.val);
        while (result.next != null) {
            System.out.println(result.next.val);
            result = result.next;
        }

    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head; // Возвращаем обновленную голову списка
    }
}
