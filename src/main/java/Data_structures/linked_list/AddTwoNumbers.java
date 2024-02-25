package Data_structures.linked_list;

import static Data_structures.linked_list.MergeTwoSortedLists.printList;

public class AddTwoNumbers {


    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);


        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(6);


        a1.next = a2;
        a2.next = a3;
        a3.next = null;

        b1.next = b2;
        b2.next = b3;
        b3.next = null;

        printList(addTwoNumbers(a1, b1));
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        // Указатель для текущего узла в новом списке
        ListNode current = dummy;
        // Перенос, который добавляется к следующим числам
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {

            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Сумма значений текущих узлов и переноса
            int sum = val1 + val2 + carry;

            // Рассчитываем новый перенос
            carry = sum / 10;

            // Создаем новый узел с остатком от деления суммы на 10
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Переходим к следующим узлам, если они существуют
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }


}
