package leetcode;

import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(Integer[] array) {
        if (array == null || array.length == 0) return null;
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(array[0]);
        queue.offer(root);
        int i = 1;
        while (i < array.length && !queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (i < array.length && array[i] != null) {
                TreeNode left = new TreeNode(array[i]);
                queue.offer(left);
                node.left = left;
            }
            i++;
            if (i < array.length && array[i] != null) {
                TreeNode right = new TreeNode(array[i]);
                queue.offer(right);
                node.right = right;
            }
            i++;
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        nodeDeque.offer(root);
        while (!nodeDeque.isEmpty()) {
            TreeNode cur = nodeDeque.poll();
            if (cur == null) {
                list.add(null);
            } else {
                list.add(cur.val);
                nodeDeque.offer(cur.left);
                nodeDeque.offer(cur.right);
            }
        }
        while (!list.isEmpty() && list.getLast() == null) {
            list.removeLast();
        }
        System.out.println(list);
    }
}
