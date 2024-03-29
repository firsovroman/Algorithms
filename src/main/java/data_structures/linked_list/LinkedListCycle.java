package data_structures.linked_list;

public class LinkedListCycle {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;

        System.out.println(hasCycle(listNode1));

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode curFast = head;
        ListNode curSlow = head;

        int counter = 0;
        while (curFast.next != null) {
            curFast = curFast.next;
            if(curFast.equals(curSlow)) {
                return true;
            }
            if(counter % 2 == 0) {
                curSlow = curSlow.next;
            }
            counter++;
        }

        return false;
    }

}

