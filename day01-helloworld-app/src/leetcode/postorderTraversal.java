package leetcode;
import java.util.*;
/*
145.二叉树的后续遍历
输入：root = [1,null,2,3]
输出：[3,2,1]
Solution2:迭代方法：反向插入法。根-右-左 每次插到链表头部
 */
public class postorderTraversal {
    public static List<Integer> Solution2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null)
            {
                stack.push(cur.right);
            }
        }
        return list;
    }

    public static List<Integer> Solution1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.addAll(Solution1(root.left));
            list.addAll(Solution1(root.right));
            list.add(root.val);
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
