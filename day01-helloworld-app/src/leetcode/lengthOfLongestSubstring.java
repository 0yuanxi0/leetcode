package leetcode;

import java.util.*;

//3.无重复字符的最长子串 滑动窗口
public class lengthOfLongestSubstring {
    public static int Solution(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        char[] ss = s.toCharArray();
        for (int l = 0, r = 0; r < ss.length; r++) {
            while (set.contains(ss[r])) {//要用while一直检查有没有重复的
                set.remove(ss[l]);
                l++;
            }
            set.add(ss[r]);
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            System.out.println(Solution(s));
        }

        sc.close();


    }


}
