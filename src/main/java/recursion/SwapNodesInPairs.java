package recursion;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;


        System.out.println(swapPairs(a1).val);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextPair = head.next.next;
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = swapPairs(nextPair);
        return newHead;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}