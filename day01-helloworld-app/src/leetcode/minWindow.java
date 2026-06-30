package leetcode;

import java.util.*;

/*
76.最小覆盖字串
给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，
使得该子串包含 t 中的每一个字符（包括重复字符）。如果没有这样的子串，返回空字符串 ""。
输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 */
public class minWindow {
    public static String Solution(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        //need数组保存的是t中的字符缺多少，为正数就是缺，0是正好，负数是有富裕
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++)
            need[t.charAt(i)]++;
        int left = 0, right = 0, minlen = Integer.MAX_VALUE;
        int countneed = t.length();
        int start = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (need[c] > 0) countneed--;
            need[c]--;
            right++;
            while (countneed == 0) {
                if (right - left < minlen) {
                    start = left;
                    minlen = right - left;
                }
                char cc = s.charAt(left);
                //重点 如果need[cc]++写在后面，这里就应该是大于等于>= 0的时候表明这个正好就是那唯一一个 去掉了就不行了
//                if (need[cc] >= 0) {
//                    countneed++;
//                }
//                need[cc]++;
                need[cc]++;
                if(need[cc]>0)
                    countneed++;
                left++;
            }
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start + minlen);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(Solution(s, t));
    }
}
