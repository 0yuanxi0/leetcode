package leetcode;
import java.util.*;
/*
101.对称二叉树
输入：root = [1,2,2,3,4,4,3]
输出：true
Solution1:递归O(n)O(n)
Solution2:迭代O(n)O(n)
 */
public class isSymmetric {
    public static boolean Solution2(TreeNode root){
        return check2(root, root);
    }
    public static boolean check2(TreeNode p, TreeNode q){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()){
            p = queue.poll();
            q = queue.poll();
            if(p == null && q == null) continue;
            if(p == null || q == null || (p.val != q.val)) return false;
            queue.offer(p.left);
            queue.offer(q.right);
            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }
    public static boolean Solution1(TreeNode root)
    {
        return check1(root.left, root.right);
    }
    public static boolean check1(TreeNode p,TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val && check1(p.left, q.right) && check1(p.right, q.left);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 7;
        Integer[] array = new Integer[]{1,2,2,3,4,4,3};
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
