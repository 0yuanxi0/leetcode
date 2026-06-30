package leetcode;

import java.util.*;

/*
142.环形链表2
给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
不允许修改 链表。
输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。
Solution1：用哈希表判断是否有环， O(n) O(n)
Solution2:快慢指针，从相遇点到入环点的距离加上 n−1 圈的环长，恰好等于从链表头部到入环点的距离。
当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。
起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。

 */
public class detectCycle {

    public static ListNode Solution1(ListNode head) {
        ListNode p = head;
        Set<ListNode> set = new HashSet<>();
        while (p != null) {
            if (set.contains(p)) return p;
            set.add(p);
            p = p.next;
        }
        return null;
    }

    public static ListNode Solution2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next == null) return null;
        ListNode start = head;
        while (slow != start) {
            slow = slow.next;
            start = start.next;
        }
        return slow;
    }

    private static ListNode createCycle(int[] vals, int pos) {
        if (vals.length == 0 || pos == -1) return null;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode p = null;
        for (int i = 0; i < vals.length; i++) {
            tail.next = new ListNode(vals[i]);
            tail = tail.next;
            if (pos == i) {
                p = tail;
            }
        }
        if (pos >= 0 && p != null) {
            tail.next = p;
        }
        return dummy.next;
    }

    private static int getNodeIndex(ListNode head, ListNode target) {
        int index = 0;
        while (head != null) {
            if (head == target) return index;
            head = head.next;
            index++;
            if (index > 10000) return -1;
        }
        return index;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), pos = sc.nextInt();
        int[] vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = sc.nextInt();
        }
        ListNode head = createCycle(vals, pos);
        int x = getNodeIndex(head, Solution2(head));
        if (x == -1 || head == null) {
            System.out.println("没有环");
        } else {
            System.out.println("环开始节点的索引是：" + x);
        }
        sc.close();
    }
}
