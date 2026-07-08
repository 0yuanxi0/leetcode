package leetcode;

import java.util.*;

/*
94.二叉树的中序遍历
输入：root = [1,null,2,3]
输出：[1,3,2]
Solution1：递归
Solution1：迭代
 */
public class inorderTraversal {

    public static List<Integer> Solution2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    public static List<Integer> Solution1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.addAll(Solution1(root.left));
            list.add(root.val);
            list.addAll(Solution1(root.right));
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            String next = sc.next();
            if ("null".equals(next)) {
                array[i] = null;
            } else {
                array[i] = Integer.parseInt(next);
            }
        }
        TreeNode root = TreeNode.buildTree(array);
        System.out.println(Solution2(root));
        sc.close();
    }
}
