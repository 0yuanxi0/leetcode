package leetcode;

import java.util.*;

/*
23.合并K个有序链表
给你一个链表数组，每个链表都已经按升序排列。
请你将所有链表合并到一个升序链表中，返回合并后的链表。
输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
Solution1:按顺序进行排序，把每次排好的用ans进行更新。O(k2n) O(1)
Solution2:分治合并 O(Kn logk)
 */
public class MergeKLists {

    public static ListNode Solution2(ListNode[] lists)
    {
        return merge(lists, 0, lists.length -1);
    }

    private static ListNode merge(ListNode[] lists, int l, int r){
        if(l == r) return lists[l];
        if(l > r) return null;
        int mid = (l + r) >> 1;
        return Merge(merge(lists, l ,mid), merge(lists, mid + 1, r));
    }
    public static ListNode Solution1(ListNode[] lists)
    {
        ListNode ans = null;
        for (ListNode listNode : lists) {
            ans = Merge(ans, listNode);
        }
        return ans;
    }

    private static ListNode Merge(ListNode left, ListNode right) {
        if (left == null || right == null)
            return (left != null) ? left : right;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                tail.next = new ListNode(left.val);
                left = left.next;
            } else {
                tail.next = new ListNode(right.val);
                right = right.next;
            }
            tail = tail.next;
        }
        tail.next = (left != null) ? left : right;
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ListNode[] headList = new ListNode[k];
        for (int i = 0; i < k; i++)
        {
            int n = sc.nextInt();
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            for (int j = 0; j < n; j++) {
                tail.next = new ListNode(sc.nextInt());
                tail = tail.next;
            }
            ListNode subHead = dummy.next;
            headList[i] = subHead;
        }
        ListNode.printList(Solution2(headList));
        sc.close();
    }
}
