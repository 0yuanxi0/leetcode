package leetcode;
import java.util.*;
/*
543.二叉树的直径
给你一棵二叉树的根节点，返回该树的 直径 。
二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
两节点之间路径的 长度 由它们之间边数表示。
输入：root = [1,2,3,4,5]
输出：3
解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
 */
public class diameterOfBinaryTree {
    static int ans = 0;
    public static int Solution1(TreeNode root)
    {
        Depth(root);
        return ans;
    }
    private static int Depth(TreeNode root){
        if(root == null) return 0;
        int left = Depth(root.left);
        int right = Depth(root.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        Integer[] array = new Integer[]{1,2,3,4,5};
//        for (int i = 0; i < n; i++) {
//            String next = sc.next();
//            if("null".equals(next)) array[i] = null;
//            else
//                array[i] = Integer.parseInt(next);
//        }
        System.out.println(Solution1(TreeNode.buildTree(array)));
        sc.close();
    }
}
