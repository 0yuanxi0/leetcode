package leetcode;
import java.util.*;
/*
144.前序遍历
输入：root = [1,null,2,3]
输出：[1,2,3]
 */
public class preorderTraversal {
    public static List<Integer> Solution2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        //先压右子节点
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return list;
    }

    public static List<Integer> Solution1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.add(root.val);
            list.addAll(Solution1(root.left));
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
        System.out.println(Solution1(root));
        sc.close();
    }
}
