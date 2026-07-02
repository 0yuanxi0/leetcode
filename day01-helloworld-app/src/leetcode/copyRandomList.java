package leetcode;
import java.util.*;


/*
138.随机链表的复制
给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，
并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
返回复制链表的头节点。
用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
你的代码 只 接受原链表的头节点 head 作为传入参数。
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 */
public class copyRandomList {
    public static Node Solution1(Node head)
    {
        if(head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while(cur != null)
        {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null)
        {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
    public static void printRandomList(Node head)
    {
        Node cur = head;
        int index = 0;
        while(cur != null)
        {
            String randomInfo = (cur.random == null) ? "null" : "节点" + getNodeIndex(head, cur.random);
            System.out.println("节点" + index + ":val=" + cur.val +", random指向" + randomInfo);
            cur = cur.next;
            index++;
        }
    }
    private static int getNodeIndex(Node head, Node target)
    {
        Node cur = head;
        int index = 0;
        while(cur != null)
        {
            if(cur == target) return index;
            cur = cur.next;
            index++;
        }
        return -1;
    }
    public static void main(String[] args) {
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

// 用next连接成链表
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

// 设置random指针
        node0.random = null;      // [7, null] - 不指向任何人
        node1.random = node0;     // [13, 0] - 指向索引0的节点
        node2.random = node4;     // [11, 4] - 指向索引4的节点
        node3.random = node2;     // [10, 2] - 指向索引2的节点
        node4.random = node0;
        System.out.println("原链表：");
        printRandomList(node0);
        System.out.println("\n复制后的链表：");
        printRandomList(Solution1(node0));
    }
}
