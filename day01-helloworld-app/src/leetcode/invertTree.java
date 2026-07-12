package leetcode;
import java.util.*;
/*
226.翻转二叉树
Solution：递归O(n)O(n)
输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
 */
public class invertTree {
    public static TreeNode Solution(TreeNode root)
    {
        if(root == null) return null;
        else{
            TreeNode left = Solution(root.left);
            TreeNode right = Solution(root.right);
            root.left = right;
            root.right = left;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 7;
        Integer[] array = new Integer[]{4,2,7,1,3,6,9};
//        for (int i = 0; i < n; i++) {
//            String next = sc.next();
//            if("null".equals(next)) array[i] = null;
//            else
//                array[i] = Integer.parseInt(next);
//        }
        System.out.println(levelOrder.Solution1(Solution(TreeNode.buildTree(array))));
        sc.close();
    }
}
