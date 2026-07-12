package leetcode;

import com.sun.source.tree.Tree;

import java.util.*;

/*
104.二叉树的最大深度
输入：root = [3,9,20,null,null,15,7]
输出：3
Solution1:广搜O(n)O(n)
Solution2:深搜O(n)O(height)
 */
public class maxDepth {

    public static int Solution2(TreeNode root){
        if(root == null) return 0;
        else
        {
            int lenLeft = Solution2(root.left);
            int lenRight = Solution2(root.right);
            return Math.max(lenLeft, lenRight) + 1;
        }
    }
    public static int Solution1(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] array = new Integer[]{3, 9, 20, null, null, 15, 7};
//        for (int i = 0; i < n; i++) {
//            String next = sc.next();
//            if("null".equals(next)) array[i] = null;
//            else
//                array[i] = Integer.parseInt(next);
//        }
        System.out.println(Solution2(TreeNode.buildTree(array)));
        sc.close();
    }
}
