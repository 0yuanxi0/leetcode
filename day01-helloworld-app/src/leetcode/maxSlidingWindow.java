package leetcode;

import java.util.*;

/*
题目描述：
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回 滑动窗口中的最大值 。

Solution1：暴力，遍历每个滑动窗口，O(n2)
Solution2：优先队列，O(nlogn)
Solution2：单调双端队列，O(n) 新元素进来时，比它小的旧元素永远没机会当最大值了，直接扔掉。

 */
public class maxSlidingWindow {
    public static List<Integer> Solution1(int[] nums, int k) {
        //int[] res = new int[nums.length - k + 1];
        List<Integer> list = new ArrayList<>();
        for (int l = 0, r = l + k - 1; l <= nums.length - k && r < nums.length; l++, r++) {
            int max_w = nums[l];
            for (int i = l; i <= r; i++) {
                max_w = Math.max(max_w, nums[i]);
            }
            list.add(max_w);
        }
        return list;
    }

    public static int[] Solution2(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; i++)
            q.offer(new int[]{nums[i], i});
        res[0] = (q.peek()[0]);
        for (int i = k; i < nums.length; i++) {
            q.offer(new int[]{nums[i], i});
            while (q.peek()[1] <= i - k)
                q.poll();
            res[i - k + 1] = (q.peek()[0]);
        }
        return res;
    }

    public static int[] Solution3(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new LinkedList<>();//单调队列存的是数组的索引，便于直接删掉过期索引
        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i])
                q.pollLast();
            q.offerLast(i);
        }
        int[] res = new int[n - k + 1];
        res[0] = nums[q.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i])
                q.pollLast();
            q.offerLast(i);
            while (q.peekFirst() <= i - k)
                q.pollFirst();
            res[i - k + 1] = nums[q.peekFirst()];
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();
            int[] res = Solution3(nums, k);
            for (int i = 0; i < res.length; i++)
                System.out.print(res[i] + " ");
//            System.out.println("Solution1:" + Solution1(nums, k));
//            System.out.print("Solution2:" + Solution2(nums, k));
        }
        sc.close();
    }
}
