package leetcode;
import  java.util.*;
/*
2.两数相加
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
Solution1:模拟
 */
public class addTwoNumbers {
    public static ListNode Solution1(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        int index1, index2;
        while(l1 != null || l2 != null){
            index1 = l1 == null ? 0 : l1.val;
            index2 = l2 == null ? 0 : l2.val;
            tail.next = new ListNode((index2 + index1 + carry) % 10);
            tail = tail.next;
            carry = (index1 + index2 + carry) / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0) tail.next = new ListNode(carry);
        return dummy.next;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len1 = sc.nextInt(), len2 = sc.nextInt();
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
        ListNode tail1 = dummy1, tail2 = dummy2;
        for (int i = 0; i < len1; i++) {
            tail1.next = new ListNode(sc.nextInt());
            tail1 = tail1.next;
        }
        for (int i = 0; i < len2; i++) {
            tail2.next = new ListNode(sc.nextInt());
            tail2 = tail2.next;
        }
        ListNode head1 = dummy1.next, head2 = dummy2.next;
        ListNode head = Solution1(head1, head2);
        while(head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
        sc.close();
    }
}
