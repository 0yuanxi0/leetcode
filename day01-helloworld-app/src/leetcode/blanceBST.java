package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
1382. 将二叉搜索树变平衡
给你一棵二叉搜索树，请你将它重新排列成一棵高度平衡的二叉搜索树。
高度平衡二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
输入：root = [1,null,2,null,3,null,4,null,null]
输出：[2,1,3,null,null,null,4]
*/
public class blanceBST {
    private static List<Integer> list = new ArrayList<>();

    public static TreeNode Solution1(TreeNode root) {
        list.clear();
        inorder(root);
        return build(0, list.size() - 1);
    }

    public static TreeNode build(int l, int r) {
        int mid = (l + r) >> 1;
        TreeNode o = new TreeNode(list.get(mid));
        if(l <= mid -1){
            o.left = build(l, mid - 1);
        }
        if(r >= mid + 1){
            o.right = build(mid + 1, r);
        }
        return o;
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int n = 4;
        Integer[] array = new Integer[]{1,null,2,null,3,null,4,null,null};
//        for (int i = 0; i < n; i++) {
//            String next = sc.next();
//            if ("null".equals(next)) {
//                array[i] = null;
//            } else {
//                array[i] = Integer.parseInt(next);
//            }
//        }
        TreeNode root = TreeNode.buildTree(array);
        System.out.println(levelOrder.Solution1(Solution1(root)));
    }
}
