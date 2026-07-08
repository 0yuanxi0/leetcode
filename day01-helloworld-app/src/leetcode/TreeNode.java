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
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i<array.length) {
            TreeNode node = queue.poll();
            //左子节点
            if(i < array.length && array[i] != null)
            {
                node.left = new TreeNode(array[i]);
                queue.add(node.left);
            }
            i++;
            //右子节点
            if(i < array.length && array[i] != null)
            {
                node.right = new TreeNode(array[i]);
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
