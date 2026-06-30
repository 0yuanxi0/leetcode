package leetcode;

import java.util.*;

/*
189.轮转数组
给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
Solution1: 使用额外的数组 时间复杂度 O(n) 空间复杂度O(n)
Solution2：数组翻转，整体翻转，两个区间翻转 时间复杂度 O(n) 空间复杂度O(1)
 */
public class retate {
    public static void Solution1(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, n);
    }

    public static void Solution2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[]nums, int l, int r)
    {
        while(l<r)
        {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        //Solution1(nums, k);
        Solution2(nums, k);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        sc.close();
    }
}
