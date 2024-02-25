package data_structures.linked_list;

import static data_structures.linked_list.RemoveLinkedListElements.printList;

public class OddEvenLinkedList {

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


        printList(oddEvenList(a1));
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode oddCurrent = oddHead;
        ListNode evenCurrent = evenHead;

        while (evenCurrent != null && evenCurrent.next != null) {
            oddCurrent.next = evenCurrent.next; // Связываем узлы с нечетными индексами
            oddCurrent = oddCurrent.next;
            evenCurrent.next = oddCurrent.next; // Связываем узлы с четными индексами
            evenCurrent = evenCurrent.next;
        }

        // Объединяем списки с нечетными и четными индексами
        oddCurrent.next = evenHead;

        return oddHead;
    }

}
