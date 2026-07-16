package leetcode;
import com.sun.source.tree.Tree;

import java.util.*;
/*
199. 二叉树的右视图
给定一个二叉树的 根节点 root，想象自己站在它的右侧，
按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
输入：root = [1,2,3,null,5,null,4]
输出：[1,3,4]
 */
public class rightSideView {

    public static List<Integer> Solution1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            TreeNode r1 = queue.poll();
            list.add(r1.val);
            if(r1.right != null) queue.offer(r1.right);
            if(r1.left != null) queue.offer(r1.left);
            for (int i = 1; i < len; i++) {
                TreeNode r2 = queue.poll();
                if(r2.right != null) queue.offer(r2.right);
                if(r2.left != null) queue.offer(r2.left);
            }
        }
        return list;
    }
    public static List<Integer> Solution2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode r2 = queue.poll();
                if(i == len - 1) {
                    list.add(r2.val);
                }
                if (r2.left != null) queue.offer(r2.left);
                if (r2.right != null) queue.offer(r2.right);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,3,null,5,null,4};
        TreeNode root = TreeNode.buildTree(array);
        System.out.println(Solution2(root));
    }
}
