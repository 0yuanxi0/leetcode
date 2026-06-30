package leetcode;
import java.util.*;
/*
25.K个一组翻转链表
给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，
那么请将最后剩余的节点保持原有顺序。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
pre  cur  nex
 */
public class reverseKGroup {
    public static ListNode Solution1(ListNode head, int k)
    {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        while(head != null)
        {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if(tail == null)
                {
                    return dummy.next;
                }
            }
            ListNode[] list = reverse(head, tail);
            head = list[0];
            tail = list[1];
            pre.next = head;
            pre = tail;
            head = tail.next;
        }
        return dummy.next;
    }
    public static ListNode[] reverse(ListNode head, ListNode tail)
    {
        ListNode prev = tail.next;
        ListNode cur = head;
        while(prev != tail)
        {
            ListNode nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }
        return new ListNode[]{tail, head};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int i = 0; i < n; i++) {
            tail.next = new ListNode(sc.nextInt());
            tail = tail.next;
        }
        ListNode head = dummy.next;
        ListNode.printList(Solution1(head, k));
        sc.close();
    }
}
