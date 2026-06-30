package leetcode;

import java.util.*;

/*
238.除了自身以外数组的乘积
给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除了 nums[i] 之外其余各元素的乘积 。
题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
请 不要使用除法，且在 O(n) 时间复杂度内完成此题
输入: nums = [1,2,3,4]
输出: [24,12,8,6]
Solution: 分别求得i两边部分的乘积 时间O(n) 空间O(n)
 */
public class productExceptSelf {

    public static int[] Solution(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] l = new int[n];//数组l[i]表示 i 左侧所有值的乘积 [0,i-1]
        int[] r = new int[n];//数组r[i]表示 i 右侧所有值的乘积 [i+1,n-1]
        l[0] = 1;
        r[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = l[i] * r[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] ans  = Solution(nums);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        sc.close();
    }
}
