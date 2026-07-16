package leetcode;
import java.util.*;
/*
107.二叉树的层次遍历2
给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。
（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
输入：root = [3,9,20,null,null,15,7]
输出：[[15,7],[9,20],[3]]
 */
public class levelOrderBottom {
    public static List<List<Integer>> Solution(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) return lists;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int len = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode cur = deque.poll();
                list.add(cur.val);
                if(cur.left != null) deque.offer(cur.left);
                if(cur.right != null) deque.offer(cur.right);
            }
            lists.addFirst(list);
        }
        return lists;
    }
    public static void main(String[] args) {

    }
}
