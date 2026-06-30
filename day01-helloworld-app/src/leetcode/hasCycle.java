package leetcode;

import java.util.*;

/*
141.环形链表
给你一个链表的头节点 head ，判断链表中是否有环。
如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
如果链表中存在环 ，则返回 true 。 否则，返回 false 。
输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。
Solution1：用哈希表放进去判断是否有重复的值，重复了就是有环，O(n) O(n)
Solution2：快慢指针，O(n) O(1)
 */
public class hasCycle {
    public static boolean Solution1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (set.contains(p)) return true;
            set.add(p);
            p = p.next;
        }
        return false;
    }

    public static boolean Solution2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    private static ListNode creatCycleList(int[] vals, int pos) {
        if (vals.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode cycleNode = null;
        for (int i = 0; i < vals.length; i++) {
            tail.next = new ListNode(vals[i]);
            tail = tail.next;
            if (i == pos) cycleNode = tail;
        }
        if (pos >= 0 && cycleNode != null) {
            tail.next = cycleNode;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), pos = sc.nextInt();
        int[] vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = sc.nextInt();
        }
        System.out.println(Solution2(creatCycleList(vals, pos)));
        sc.close();
    }
}
