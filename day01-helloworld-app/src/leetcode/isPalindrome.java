package leetcode;

import org.w3c.dom.ls.LSException;

import java.util.*;

/*
234.回文链表
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
输入：head = [1,2,2,1]
输出：true
Solution1：先放进list中，然后用双指针 O(n) O(n)
Solution2：快慢指针找到中间位置，然后反转后半段链表，判断是否相同。
 */
public class isPalindrome {
    public static boolean Solution1(ListNode head) {
        if (head == null) return false;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (!list.get(left).equals(list.get(right))) return false;
            left++;
            right--;
        }
        return true;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static boolean Solution2(ListNode head) {
        if (head == null) return false;
        ListNode fast = head, slow = head;
        //快慢指针
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHalf = reverseList(slow.next);
        ListNode p = secondHalf;
        ListNode firstHalf = head;
        //判断回文链表
        while (p != null) {
            if (p.val != firstHalf.val) return false;
            p = p.next;
            firstHalf = firstHalf.next;
        }
        reverseList(secondHalf);
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        return true;
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
        ListNode head = dummy.next;
        System.out.println(Solution2(head));
        sc.close();
    }
}
