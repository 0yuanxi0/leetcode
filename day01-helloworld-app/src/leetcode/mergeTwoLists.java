package leetcode;

import java.util.*;

/*
21.合并两个有序链表
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
Solution1：逐个比较哪个小就插入链表中
 */
public class mergeTwoLists {
    public static ListNode Solution1(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        else if (list1 == null) return list2;
        else if (list2 == null) return list1;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if(list1.val <= list2.val)
            {
                tail.next = new ListNode(list1.val);
                tail = tail.next;
                list1 = list1.next;
            }else{
                tail.next = new ListNode(list2.val);
                tail = tail.next;
                list2 = list2.next;
            }
        }
        while(list1 != null)
        {
            tail.next = new ListNode(list1.val);
            tail = tail.next;
            list1 = list1.next;
        }
        while(list2 != null)
        {
            tail.next = new ListNode(list2.val);
            tail = tail.next;
            list2 = list2.next;
        }
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
