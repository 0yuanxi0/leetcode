package leetcode;

import java.util.*;

/*
230.二叉搜索树中的第k小的元素
给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（k 从 1 开始计数）。
输入：root = [3,1,4,null,2], k = 1
输出：1
Solution1：中序遍历
Solution2：记录每个节点子树节点的个数
 */
public class kthSmallest {

    public static Map<TreeNode, Integer> countMap = new HashMap<>();

    public static int buildCount(TreeNode node) {
        if (node == null) return 0;
        int count = 1 + buildCount(node.left) + buildCount(node.right);
        countMap.put(node, count);
        return count;
    }

    public static int getCount(TreeNode node) {
        return node == null ? 0 : countMap.getOrDefault(node, 0);
    }

    public static int Solution2(TreeNode root, int k) {
        if (root == null || k < 1) return -1;
        countMap.clear();
        buildCount(root);
        TreeNode cur = root;
        while (cur != null) {
            int leftCount = getCount(cur.left);
            if (leftCount == k - 1) return cur.val;
            else if (leftCount >= k) cur = cur.left;
            else {
                k = k - leftCount -1;
                cur = cur.right;
            }
        }
        return -1;
    }

    public static int Solution1(TreeNode root, int k) {
        if (root == null) return -1;
        int num = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            num++;
            if (num == k) return cur.val;
            cur = cur.right;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = 1;
        Integer[] array = new Integer[]{5, 3, 6, 2, 4, null, null, 1};
        TreeNode root = TreeNode.buildTree(array);
        System.out.println(Solution2(root, 3));
    }
}
