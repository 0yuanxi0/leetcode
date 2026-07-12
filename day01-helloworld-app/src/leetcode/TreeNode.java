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
        Queue<TreeNode> queue = new LinkedList<>();
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
}
