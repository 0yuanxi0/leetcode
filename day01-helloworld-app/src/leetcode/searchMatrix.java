package leetcode;

import java.util.*;

/*
240.搜索二位矩阵2
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
输出：true
Solution1：从右上角开始，排除行列 时间O(m+n)
Solution2:对每一行进行二分查找 O(mlogn)
Solution3:两层循环查找O(mn)
 */
public class searchMatrix {
    public static boolean Solution1(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }

    public static boolean Solution2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int[] nums : matrix) {
            int index = search(nums, target);
            if (index >= 0) return true;
        }
        return false;

    }

    public static int search(int[] nums, int target)//二分查找
    {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt(), target = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(Solution2(matrix, target));
        //System.out.println(Arrays.deepToString(matrix));
        sc.close();
    }
}
