package Begin.linked_list;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode2;

        listNode1.next = listNode2;
        listNode2.next = listNode1;

        System.out.println(detectCycle(listNode1).val);
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        Set<ListNode> set = new HashSet<>();
        set.add(head);

        ListNode cur = head;
        while (cur.next != null) {
            if(set.contains(cur.next)) {
                return cur.next;
            }
            set.add(cur.next);
            cur = cur.next;
        }

        return null;
    }

}
