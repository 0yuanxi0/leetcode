package leetcode;

import java.util.*;
import java.util.Scanner;

/*
53.最大子数组和
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
子数组是数组中的一个连续部分。
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
Solution1：暴力双重循环O(n2)
Soluion2：动规dp O(n)
 */
public class maxSubArray {
    public static int Solution1(int[] nums) {
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > ans)
                    ans = sum;
            }
        }
        return ans;
    }

    public static int Solution2(int[] nums) {
        int ans = nums[0];
        //dp[]代表以i结尾的最长子数组的和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        System.out.println(Solution2(nums));
    }
}
