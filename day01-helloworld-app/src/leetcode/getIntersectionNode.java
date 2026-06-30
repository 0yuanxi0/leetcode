package leetcode;

import java.util.*;
/*
160.相交链表
给你两个单链表的头节点 headA 和 headB ，
请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
评测系统 的输入如下（你设计的程序 不适用 此输入）：

intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
listA - 第一个链表
listB - 第二个链表
skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
输出：Intersected at '8'
Solution1：让长的先走 然后让两个同一起跑线一起走
Solution2：双指针
假设：
链表 A 长度 = a + c（a 是独有部分，c 是公共部分）
链表 B 长度 = b + c（b 是独有部分，c 是公共部分）
那么：
pA 走的距离 = a + c + b（走完 A 后在 B 上走了 b 步）
pB 走的距离 = b + c + a（走完 B 后在 A 上走了 a 步）
因为 a + c + b = b + c + a，所以两个指针会在相交点相遇！
 */


public class getIntersectionNode {

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static ListNode Solution1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = getLength(headA), lenB = getLength(headB);
        ListNode longer = lenA > lenB ? headA : headB;
        ListNode shorter = lenA > lenB ? headB : headA;
        int diff = Math.abs(lenA-lenB);
        for (int i = 0; i < diff; i++) {
            longer = longer.next;
        }
        while (longer != null) {
            if (longer == shorter) return longer;
            longer = longer.next;
            shorter = shorter.next;
        }
        return null;
    }
    public static ListNode Solution2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while(pA != pB)
        {
            pA = pA==null ? headB : pA.next;
            pB = pB==null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode common1 = new ListNode(8);
        ListNode common2 = new ListNode(4);
        ListNode common3 = new ListNode(5);

        node1.next = node2;
        node2.next = common1;
        common1.next = common2;
        common2.next = common3;

        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(1);
        node3.next = node4;
        node4.next = node5;
        node5.next = common1;

        ListNode result = Solution2(node1, node3);
        if (result != null) {
            System.out.println("Intersected at '" + result.val + "'");
        } else {
            System.out.println("No intersection");
        }
    }


}
