package leetcode;

import java.util.*;

public class threeSum {

    public static List<List<Integer>> Solution(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            int target = -nums[i];
            //将后两个数用双指针去寻找两数的和等于第一个数
            while (l < r) {
                int tmp = nums[l] + nums[r];
                if (tmp == target) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;

                } else if (tmp < target)
                    l++;
                else
                    r--;
            }
        }
        return list;
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
