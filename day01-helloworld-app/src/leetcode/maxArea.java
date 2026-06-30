package leetcode;

import java.sql.SQLOutput;
import java.util.*;

public class maxArea {

    public static int Solution(int[] height) {
        int max_ = 0, l = height.length;
        int left = 0, right = l - 1;

        while (left < right) {
            int cur = Math.min(height[left], height[right]) * (right - left);
            max_ = Math.max(cur, max_);
            if (height[left] <= height[right])
                left++;
            else
                right--;
        }
        return max_;
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
