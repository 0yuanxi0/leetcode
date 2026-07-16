package leetcode;

import java.util.*;

/*
98.验证二叉搜索树
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
节点的左子树只包含 严格小于 当前节点的数。
节点的右子树只包含 严格大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
输入：root = [2,1,3]
输出：true
Solution1:递归O(n)O(H)
Solution2:中序遍历是绝对单调递增的 O(n) O(n)
 */
public class isValidBST {
    public static boolean Solution2(TreeNode root) {
        if (root == null) return true;
        long preOrder = Long.MIN_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;

            }
            cur = stack.pop();
            if (cur.val <= preOrder) return false;
            preOrder = cur.val;
            cur = cur.right;
        }
        return true;
    }

    public static boolean Solution1(TreeNode root) {
        return helper(root, null, null);
    }

    private static boolean helper(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] array = new Integer[]{5, 1, 4, null, null, 3, 6};
//        for (int i = 0; i < n; i++) {
//            String next = sc.next();
//            if ("null".equals(next)) {
//                array[i] = null;
//            } else {
//                array[i] = Integer.parseInt(next);
//            }
//        }
        TreeNode root = TreeNode.buildTree(array);
        System.out.println(Solution2(root));
    }
}
