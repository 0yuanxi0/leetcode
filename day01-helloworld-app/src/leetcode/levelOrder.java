package leetcode;
import java.util.*;
/*
102.层序遍历
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]
 */
public class levelOrder {

    public static List<List<Integer>> Solution1(TreeNode root)
    {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return list;
        queue.offer(root);

        while(!queue.isEmpty())
        {
            List<Integer> cur = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                cur.add(node.val);
                if(node.left != null)
                {
                    queue.offer(node.left);
                }
                if(node.right != null)
                {
                    queue.offer(node.right);
                }
            }
            list.add(cur);
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            String next = sc.next();
            if("null".equals(next))
            {
                array[i] = null;
            }else
            {
                array[i] = Integer.parseInt(next);
            }
        }
        System.out.println(Solution1(TreeNode.buildTree(array)));
        sc.close();
    }
}
