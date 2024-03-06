package data_structures.linked_list;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;

        ListNode listNode2_1 = new ListNode(1);
        ListNode listNode2_2 = new ListNode(2);
        listNode2_1.next = listNode2_2;

        System.out.println(isPalindrome(listNode1)); // true
        System.out.println(isPalindrome(listNode2_1)); // false
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Находим середину списка
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Разделяем список на две части
        ListNode secondHalfStart = reverseList(slow.next);
        slow.next = null;

        // Сравниваем две части списка
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Восстанавливаем исходный список
        slow.next = reverseList(secondHalfStart);

        return true;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

//    public static boolean isPalindrome(ListNode head) {
//        if (head == null || head.next == null) {
//            return true;
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        ListNode cur = head;
//        while (cur != null) {
//            sb.append(cur.val);
//            cur = cur.next;
//        }
//
//        String forward = sb.toString();
//        String back = sb.reverse().toString();
//
//        return forward.equals(back);
//    }

}
