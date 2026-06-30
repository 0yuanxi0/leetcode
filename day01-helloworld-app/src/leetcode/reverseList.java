package leetcode;

import java.util.*;

/*
206.翻转链表
    给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
Solution1:迭代
Solution2:递归
 */
public class reverseList {

    public static ListNode Solution1(ListNode head) {
        ListNode pre = null, cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static ListNode Solution2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newtHead = Solution2(head.next);
        head.next.next = head;
        head.next = null;
        return newtHead;
    }

    public static void main(String[] args) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            tail.next = new ListNode(sc.nextInt());
            tail = tail.next;
        }
        ListNode head = dummy.next;
        head = Solution2(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        sc.close();
    }
}
