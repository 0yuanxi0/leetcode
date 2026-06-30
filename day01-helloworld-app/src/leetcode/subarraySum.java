package leetcode;

import java.util.*;

//560.和为K的子数组
//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
//子数组是数组中元素的连续非空序列。
//solution1 暴力枚举 O(n2)
//solution2 前缀和+哈希表O(n)
public class subarraySum {
    public static int Solution1(int[] nums, int k) {
        int len = nums.length;
        int res = 0;
        for (int start = 0; start < len; start++) {
            int sum = 0;
            for (int end = start; end < len; end++) {
                sum += nums[end];
                if (sum == k) res++;
            }
        }
        return res;
    }

    public static int Solution2(int[] nums, int k) {
        int res = 0;
        int l = nums.length;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < l; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                res += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return res;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(Solution1(nums, k));
            System.out.println(Solution2(nums, k));

        }
        sc.close();


    }

}
