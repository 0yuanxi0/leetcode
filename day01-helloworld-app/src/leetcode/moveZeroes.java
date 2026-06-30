package leetcode;

import java.util.*;

public class moveZeroes {
    //双指针移动，将所有的0元素都放在后面，数组原地移动
    public static void Solution(int[] nums) {
        int l = nums.length, left = 0, right = 0;
        while (right < l) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();
            Solution(nums);
            for (int i = 0; i < n; i++)
                System.out.print(nums[i] + " ");
        }
        sc.close();
    }
}
