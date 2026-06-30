package leetcode;

import java.util.*;

//438.找到字符串中所有字母异位词 滑动窗口
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
public class findAnagrams {

    public static List<Integer> Solution(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int[] countP = new int[26];
        int[] window = new int[26];
        for (char c : p.toCharArray())
            countP[c - 'a']++;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            int inx = s.charAt(right)-'a';
            window[inx]++;
            //right-left+1 滑动窗口的大小
            if (right-left+1 < p.length()) {
                continue;
            }
            if (right-left+1 > p.length()) {
                window[s.charAt(left)-'a']--;
                left++;
            }
            if (Arrays.equals(window, countP)) {
                res.add(left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            //sc.nextLine();
            String p = sc.next();
            System.out.println(Solution(s, p));
        }

        sc.close();
    }


}
