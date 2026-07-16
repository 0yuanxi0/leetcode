package leetcode;

import com.sun.source.tree.Tree;

import java.util.*;

/*
437.路径总和3
给定一个二叉树的根节点 root ，
和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的
（只能从父节点到子节点）。
输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
输出：3
Solution1：DFS双重递归，时间：最差O(n2) 平均O(nlogn) 空间O(H)
Solution2:DFS+前缀和 O(N) O(N)
 */
public class pathSum {

    public static int Solution2(TreeNode root, int targetSum){
        // 定义前缀和 <前缀和、出现的次数>
        if(root == null) return 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, 0L, targetSum, map);
    }
    public static int dfs(TreeNode root, long curSum, int targetSum, Map<Long, Integer> map){
        if(root == null) return 0;
        int ans = 0;
        // 更新当前路径的前缀和
        curSum += root.val;
        // 查看哈希表中是否存在满足条件的前缀和
        ans += map.getOrDefault((curSum - targetSum), 0);
        // 将当前前缀和加入哈希表，并递归左右子树
        map.put(curSum, map.getOrDefault(curSum, 0) +  1);
        ans += dfs(root.left, curSum, targetSum, map);
        ans += dfs(root.right, curSum, targetSum, map);
        // 回溯前去掉当前前缀和
        map.put(curSum, map.get(curSum) - 1);
        return ans;
    }
    public static int Solution1(TreeNode root, int targetSum) {
        if(root == null) return 0;
        int ans = rootSum(root, targetSum);
        ans += Solution1(root.left, targetSum);
        ans += Solution1(root.right, targetSum);
        return ans;
    }

    public static int rootSum(TreeNode root, long targetSum) {
        if (root == null) return 0;
        int ans = 0;
        if (root.val == targetSum) ans++;
        ans += rootSum(root.left, targetSum - root.val);
        ans += rootSum(root.right, targetSum - root.val);
        return ans;
    }
    public static void main(String[] args) {
        Integer[] array = new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode root = TreeNode.buildTree(array);
        System.out.println(Solution2(root, 8));
    }
}
