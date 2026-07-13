package leetcode;

import java.util.Scanner;

/*
108. 将有序数组转化为二叉搜索树
给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树
输入：nums = [-10,-3,0,5,9]
输出：[0,-3,9,-10,null,5]
 */
public class sortedArrayToBST {

    public static TreeNode Solution1(int[] nums) {
        return build(0, nums.length - 1, nums);
    }

    public static TreeNode build(int l, int r, int[] nums) {
        int mid = (l + r) >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        if (l <= mid - 1) {
            node.left = build(l, mid - 1, nums);
        }
        if (r >= mid + 1) {
            node.right = build(mid + 1, r, nums);
        }
        return node;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int n = 4;
        int[] array = new int[]{-10,-3,0,5,9};
//        for (int i = 0; i < n; i++) {
//            String next = sc.next();
//            if ("null".equals(next)) {
//                array[i] = null;
//            } else {
//                array[i] = Integer.parseInt(next);
//            }
//        }
        System.out.println(levelOrder.Solution1(Solution1(array)));
    }
}
