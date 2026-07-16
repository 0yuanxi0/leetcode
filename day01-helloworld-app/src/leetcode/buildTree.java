package leetcode;

import java.util.*;

/*
105.通过前序和中序遍历构造二叉树
给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
 inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]
 */
public class buildTree {

    static Map<Integer, Integer> map;
    static int preOrderIndex = 0;

    public static TreeNode Solution(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        preOrderIndex = 0;
        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }

    /**
     * 递归构建子树的辅助函数
     *
     * @param preorder     前序遍历数组
     * @param inorderStart 当前子树在中序遍历中的起点索引
     * @param inorderEnd   当前子树在中序遍历中的终点索引
     */
    private static TreeNode buildTreeHelper(int[] preorder, int inorderStart, int inorderEnd) {
        // 基准情况，如果当前区间无效，说明子树为空
        if (inorderStart > inorderEnd) return null;
        // 从前序遍历中获取当前数根节点
        int rootVal = preorder[preOrderIndex];
        TreeNode root = new TreeNode(rootVal);
        preOrderIndex++;

        //在中序遍历中定位根节点的索引
        int rootIndexInorder = map.get(root.val);
        //递归构建左右子树
        TreeNode left = buildTreeHelper(preorder, inorderStart, rootIndexInorder - 1);
        TreeNode right = buildTreeHelper(preorder, rootIndexInorder + 1, inorderEnd);
        root.left = left;
        root.right = right;
        return root;
    }
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7}, inorder = new int[]{9,3,15,20,7};
        TreeNode root = Solution(preorder, inorder);
        TreeNode.printTree(root);
    }
}
