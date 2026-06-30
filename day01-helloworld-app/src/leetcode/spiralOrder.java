package leetcode;

import java.util.*;

/*
54.螺旋矩阵
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
Solution1：模拟，四个方向，到边界以及访问过的元素就切换位置 时间O(mn) 空间O(m+n)
Solution2：按层模拟，每一层由四部分组成  时间O(mn) 空间O(1)
top,left . . . . top,right
.                   .
.                   .
.                   .
bottom,left. . . bottom,right
 */
public class spiralOrder {
    public static List<Integer> Solution1(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
        int m = matrix.length, n = matrix[0].length;
        int total = m * n;
        boolean[][] visted = new boolean[m][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directIndex = 0;
        int row = 0, col = 0;
        for (int i = 0; i < total; i++) {
            list.add(matrix[row][col]);
            visted[row][col] = true;
            int nextRow = row + directions[directIndex][0];
            int nextCol = col + directions[directIndex][1];
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visted[nextRow][nextCol]) {
                directIndex = (directIndex + 1) % 4;
            }
            row = row + directions[directIndex][0];
            col = col + directions[directIndex][1];
        }
        return list;
    }

    /*
    top,left . . . . top,right
    .                   .
    .                   .
    .                   .
    bottom,left. . . bottom,right
     */
    public static List<Integer> Solution2(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while (left <= right && top <= bottom)
        {
            for (int i = left; i <= right ; i++) {
                list.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom ; i++) {
                list.add(matrix[i][right]);
            }
            if(left<right && top<bottom)//确保宽度高度至少为2 不是单列 不是单行
            {
                for (int i = right-1; i >=left+1 ; i--) {
                    list.add(matrix[bottom][i]);
                }
            }
            if(left<right && top<bottom)
            {
                for (int i = bottom; i >=top+1 ; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        List<Integer> list = Solution2(matrix);
        System.out.println(list);
        sc.close();
    }
}
