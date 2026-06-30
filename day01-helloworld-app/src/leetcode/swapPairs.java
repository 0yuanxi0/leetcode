package leetcode;

import java.util.*;

/*
24.两两交换链表中的节点
给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：
输入：head = []
输出：[]
Solution1:用数组模拟，从数组头开始依次交换两个数，再用新的数组重新生成一个链表
Solution2:模拟链表的交换过程，对于每两个链表节点的交换可以用前置的temp来进行：O(n) O(1)
temp-node1-node2
temp.next = node2
node1.next = node2.next
node2.next = node1
temp = node1
Solution3: 递归 O(n)O(n)
 */
public class swapPairs {
    public static ListNode Solution3(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = head.next;
        head.next = Solution3(newHead.next);
        newHead.next = head;
        return newHead;
    }
    public static ListNode Solution2(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next, node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummy.next;
    }

    private static int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static void swap(int[] vals, int a1, int a2) {
        int temp = vals[a1];
        vals[a1] = vals[a2];
        vals[a2] = temp;
    }

    public static ListNode Solution1(ListNode head) {
        if (head == null) return null;
        ListNode tail = head;
        int len = getLength(head);
        int[] vals = new int[len];
        int l = 0;
        while (tail != null) {
            vals[l++] = tail.val;
            tail = tail.next;
        }
        int low = 0, fast = 1;
        while (fast < len) {
            swap(vals, low, fast);
            low += 2;
            fast += 2;
        }
        ListNode dummy = new ListNode(0);
        ListNode t = dummy;
        for (int i = 0; i < len; i++) {
            t.next = new ListNode(vals[i]);
            t = t.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int i = 0; i < n; i++) {
            tail.next = new ListNode(sc.nextInt());
            tail = tail.next;
        }
        ListNode.printList(Solution2(dummy.next));
        sc.close();
    }
}
