package leetcode;

import java.util.*;

/*
106.从中序和后序确定二叉树
输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
输出：[3,9,20,null,null,15,7]
 */
public class buildTree_post {

    static Map<Integer, Integer> map = new HashMap<>();
    static int postOrderIndex = 0;

    public static TreeNode Solution(int[] inorder, int[] postorder) {
        map.clear();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        postOrderIndex = postorder.length - 1;
        return buildTreePostHelper(postorder, 0, inorder.length - 1);
    }

    private static TreeNode buildTreePostHelper(int[] postorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) return null;
        // 创建根节点
        int rootVal = postorder[postOrderIndex];
        TreeNode root = new TreeNode(rootVal);
        postOrderIndex--;
        //找到中序遍历中根节点index
        int inorderIndex = map.get(rootVal);
        //递归创建右子树 左子树 先右后左
        TreeNode right = buildTreePostHelper(postorder, inorderIndex + 1, inorderEnd);
        TreeNode left = buildTreePostHelper(postorder, inorderStart, inorderIndex - 1);
        root.right = right;
        root.left = left;
        return root;
    }

    public static void main(String[] args) {
        int[] postorder = new int[]{9, 15, 7, 20, 3}, inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = Solution(inorder, postorder);
        TreeNode.printTree(root);
    }
}
