package leetcode;
import com.sun.source.tree.Tree;

import java.util.*;
/*
114. 二叉树展开为链表
给你二叉树的根结点 root ，请你将它展开为一个单链表：
展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。
输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]
Solution1:先序遍历+ 重新连接 O(n)O(n)
Solution2:原地操作 O(1)空间
1.找到左子树的最右节点
2.把右子树挂到这个最右节点的right
3.把左子树移到右边
4.left置null
5.继续处理下一个right
 */
public class flatten {

    public static void Solution2(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        TreeNode cur = root;
        while(cur != null)
        {
            if(cur.left != null){
                TreeNode prev = cur.left;
                while(prev.right != null) prev = prev.right;
                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
    public static void Solution1(TreeNode root)
    {
        List<TreeNode> list = new ArrayList<>();
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            list.add(cur);
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
        }
        TreeNode cur = root;
        while(!list.isEmpty()){
            cur.left = null;
            cur.right = list.getFirst();
            list.removeFirst();
            cur = cur.right;
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,5,3,4,null,6};
        TreeNode root = TreeNode.buildTree(array);
        Solution2(root);
        while(root != null)
        {
            System.out.print("[" + root.val + ", left=" + root.left + ", right="
                + ((root.right==null)?null:root.right.val)+"]");
            root = root.right;
        }
    }
}
