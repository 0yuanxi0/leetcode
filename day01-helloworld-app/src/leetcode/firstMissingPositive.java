package leetcode;

import java.util.*;

/*
41.缺失的第一个正数
给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
输入：nums = [1,2,0]
输出：3
解释：范围 [1,2] 中的数字都在数组中。
Solution1：哈希表直接从1开始查找，空间不是常数级
Solution2：原地置换 把每个数放到正确的位置，并找到第一个不在正确位置的数
 */
public class firstMissingPositive {
    public static int Solution1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) set.add(num);
        }
        int i = 1;
        while (set.contains(i)) {
            i++;
        }
        return i;
    }

    public static int Solution2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1]!=nums[i])
            {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        System.out.println(Solution2(nums));
        sc.close();
    }
}
