package leetcode;

import java.util.*;

public class zimuyiweici {

    public static List<List<String>>yiweici(String[] strs){
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(String str : strs)
        {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            in.nextLine();
            String[] strs = new String[n];
            for(int i=0;i<n;i++)
                strs[i] = in.nextLine();

            List<List<String>> result = yiweici(strs);
            // 对每个组内的字符串按照字典序排序
            for(List<String> group:result)
            {
                Collections.sort(group);
            }

            //对所有组按组内的第一个字符串的字典序排序
            Collections.sort(result, new Comparator<List<String>>() {
                @Override
                public int compare(List<String> o1, List<String> o2) {
                    return o1.get(0).compareTo(o2.get(0));
                }
            });

            System.out.println(result.size());
            for(List<String> group:result)
            {
                System.out.println(group.size());
                for(String str:group)
                {
                    System.out.println(str);
                }
            }

        }
        in.close();
    }

}
