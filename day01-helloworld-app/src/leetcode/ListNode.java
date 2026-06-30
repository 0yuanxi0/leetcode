package leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ;

    ListNode(int x) {
        this.val = x;
    }

    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }

    public static void printList(ListNode head)
    {
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
