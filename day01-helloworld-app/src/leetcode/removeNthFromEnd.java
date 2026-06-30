package leetcode;
import  java.util.*;
/*
19.删除链表的倒数第n个节点
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
Solution1:计算链表长度然后删除，O(n) O(1)
Solution2：栈 O(n) O(n)
Solution3:双指针O(n) O(1) 快慢指针，让快指针一开始领先慢指针n个距离，等到快指针为null的时候，慢指针正好在倒数n个节点的前一个节点
 */
public class removeNthFromEnd {
    private static int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static ListNode Solution1(ListNode head, int n) {
        int len = getLength(head);
        ListNode dummy = new ListNode(0, head);
        ListNode tail = dummy;
        int pos = len - n;
        for (int i = 0; i < pos; i++) {
            tail = tail.next;
        }
        tail.next = tail.next.next;
        return dummy.next;
    }

    public static ListNode Solution2(ListNode head, int n){
        ListNode dummy = new ListNode(0, head);
        ListNode tail = dummy;
        Deque<ListNode> stack = new LinkedList<>();
        while(tail != null)
        {
            stack.push(tail);
            tail = tail.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }
    public static ListNode Solution3(ListNode head, int n){
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while(fast != null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt(), n = sc.nextInt();
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int i = 0; i < len; i++) {
            tail.next = new ListNode(sc.nextInt());
            tail = tail.next;
        }
        ListNode head = Solution3(dummy.next, n);;
        ListNode.printList(head);
        sc.close();
    }
}
