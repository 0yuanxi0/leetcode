package leetcode;

import java.util.*;

public class twoSum{

    public static int[] twoSum(int[]nums, int target)
    {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }


        return new int[0];
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while(in.hasNext())
        {
            int n = in.nextInt();
            int target = in.nextInt();
            int[] nums = new int[n];
            for(int i=0;i<n;i++)
                nums[i] = in.nextInt();
            int[] result = twoSum(nums,target);
            if(result[0]>result[1])
            {
                int temp = result[0];
                result[0] = result[1];
                result[1] = temp;
            }
            System.out.println("\n" + result[0] + " " + result[1]);
        }
        in.close();
    }



}
