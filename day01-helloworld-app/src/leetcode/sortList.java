package leetcode;
import java.util.*;
/*
148.排序链表
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
Solution1 : List sort
Solution2：自顶向下递归归并排序，先用快慢指针找到中点，
对左右两个有序链表进行合并 O(nlogn) O(logn)
Solution3：自底向上迭代O(nlogn)O(1)
 */
public class sortList {
    public static ListNode Solution3(ListNode head)
    {
         if(head == null || head.next == null) return head;
         int len = 0;
         ListNode node = head;
         while(node != null)
         {
             len++;
             node = node.next;
         }
         ListNode dummy = new ListNode(0, head);
         for(int step = 1; step < len; step *= 2)
         {
             ListNode prev = dummy;
             ListNode curr = dummy.next;
             while(curr != null)
             {
                 ListNode left = curr;
                 ListNode right = split(left, step);
                 curr = split(right, step);
                 prev.next = Merge(left, right);
                 while(prev.next != null)
                     prev = prev.next;
             }
         }
         return dummy.next;
    }
    private static ListNode split(ListNode head, int step)
    {
        if(head == null) return null;
        for(int i = 1; i < step && head.next != null; i++)
        {
            head = head.next;
        }
        ListNode next = head.next;
        head.next = null;
        return next;
    }

    public static ListNode Solution2(ListNode head)
    {
        //递归终止条件 链表为空，或链表指向空
        if(head == null || head.next == null) return head;
        //快慢指针找出钟点
        ListNode mid = findMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode left = Solution2(head);
        ListNode right = Solution2(rightHead);
        return Merge(left, right);
    }
    //合并两个有序链表
    private static ListNode Merge(ListNode left, ListNode right)
    {
        if(left == null) return right;
        if(right == null) return left;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(left != null && right != null)
        {
            if(left.val <= right.val)
            {
                tail.next = new ListNode(left.val);
                tail = tail.next;
                left = left.next;
            }else
            {
                tail.next = new ListNode(right.val);
                tail = tail.next;
                right = right.next;
            }
        }
        if(left != null)
        {
            tail.next = left;
        }else
        {
            tail.next = right;
        }
        return dummy.next;
    }
    private static ListNode findMiddle(ListNode head)
    {
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static ListNode Solution1(ListNode head)
    {
        List<Integer> list = new ArrayList<>();
        ListNode dummy = new ListNode(0, head);
        ListNode tail = dummy.next;
        while(tail != null)
        {
            list.add(tail.val);
            tail = tail.next;
        }
        Collections.sort(list);
        tail = dummy;
        while(!list.isEmpty())
        {
            tail.next = new ListNode(list.getFirst());
            list.removeFirst();
            tail = tail.next;
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
        ListNode head = dummy.next;
        ListNode.printList(Solution3(head));
        sc.close();
    }
}
