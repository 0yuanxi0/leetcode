package leetcode;
import java.util.*;

public class longestConsecutive {

    public static int Solution(int[] nums)
    {
        Set<Integer> set = new HashSet<Integer>();
        for(int num:nums)
            set.add(num);
        int longestnum = 0;
        for(int num:set)
        {
            if(!set.contains(num-1)){
                int currentnum = num;
                int longestStack = 1;
                while(set.contains(currentnum+1))
                {
                    currentnum++;
                    longestStack++;
                }
                longestnum = Math.max(longestnum,longestStack);
            }

        }
        return longestnum;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            in.nextLine();
            int[] nums = new int[n];
            for(int i=0;i<n;i++)
                nums[i] = in.nextInt();
            System.out.println(Solution(nums));
        }
        in.close();
    }

}
