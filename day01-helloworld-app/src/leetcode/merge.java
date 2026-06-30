package leetcode;

import java.util.*;

/*
56.合并区间
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
Solution: sort
 */
public class merge {
    public static int[][] Solution(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int curl = intervals[i][0], curr = intervals[i][1];
            if (list.isEmpty()) {
                list.add(new int[]{curl, curr});
            } else {
                int prel = list.get(list.size() - 1)[0],
                    prer = list.get(list.size() - 1)[1];
                if (curl <= prer) {
                    list.set(list.size() - 1, new int[]{prel, Math.max(curr, prer)});
                } else {
                    list.add(new int[]{curl, curr});
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        int[][] intervals = Solution(nums);
//        for (int[] row : intervals) {
//            for (int num : row) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
//        }
        System.out.println(Arrays.deepToString(intervals));
        sc.close();
    }
}
