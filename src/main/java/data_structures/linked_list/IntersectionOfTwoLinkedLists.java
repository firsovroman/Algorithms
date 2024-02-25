package data_structures.linked_list;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        ListNode a0 = new ListNode(0);
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);

        ListNode b1 = new ListNode(11);
        ListNode b2 = new ListNode(22);

        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(4);

        a0.next = a1;
        a1.next = a2;
        a2.next = c1;

        b1.next = b2;
        b2.next = c1;

        c1.next = c2;
        c2.next = null;

        Integer res = (getIntersectionNode(a0, b1) != null) ? getIntersectionNode(a0, b1).val : null;
        System.out.println(res);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Проверка на пустые списки
        if (headA == null || headB == null) {
            return null;
        }

        // Находим длины списков
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        // Делаем указатели на начала списков
        ListNode ptrA = headA;
        ListNode ptrB = headB;

        // Выравниваем указатели на начало списков на расстояние, равное разнице в длинах
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                ptrA = ptrA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                ptrB = ptrB.next;
            }
        }

        // Проходим по спискам одновременно и сравниваем узлы
        while (ptrA != null && ptrB != null) {
            if (ptrA == ptrB) {
                // Найден пересекающийся узел
                return ptrA;
            }
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }

        // Списки не пересекаются
        return null;
    }

    // Вспомогательная функция для вычисления длины списка
    private static int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}
