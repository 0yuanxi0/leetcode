package leetcode;

import java.util.*;

//42.接雨水 双指针
public class trap {

    public static int Solution(int[] nums) {
        int ans = 0;
        int len = nums.length;
        int l = 0, r = len - 1;
        int lmax = 0, rmax = 0;
        while (l < r) {
            lmax = Math.max(lmax, nums[l]);
            rmax = Math.max(rmax, nums[r]);
            if (lmax <= rmax) {
                ans += lmax - nums[l];
                l++;
            } else {
                ans += rmax - nums[r];
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();
            System.out.println(Solution(nums));
        }

        sc.close();

    }

}
