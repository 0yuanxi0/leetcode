package leetcode;
import java.util.*;
public class testTree {

    public static class treeNode{
        int val;
        treeNode left;
        treeNode right;
        treeNode(){}
        treeNode(int val){this.val = val;}
        treeNode(int val, treeNode left, treeNode right){
            this.val  = val;
            this.left = left;
            this.right = right;
        }
    }

    public static treeNode myBuildTree(Integer[] array){
        if(array == null || array.length == 0) return null;
        treeNode root = new treeNode(array[0]);
        Deque<treeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while(i < array.length && !queue.isEmpty()){
            treeNode cur = queue.poll();
            if(array[i] != null)
            {
                cur.left = new treeNode(array[i]);
                queue.offer(cur.left);
            }
            i++;
            if(array[i] != null)
            {
                cur.right = new treeNode(array[i]);
                queue.offer(cur.right);
            }
            i++;
        }
        return root;
    }
    public static List<List<Integer>> level(treeNode root){
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Deque<treeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list1 = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                treeNode cur = queue.poll();
                list1.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            list.add(list1);
        }
        return list;
    }

    public static void main(String[] args){
//        Integer[] array = new Integer[]{3,9,20,null,null,15,7};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            String next = sc.next();
            if("null".equals(next)){
                array[i] = null;
            }else
            {
                array[i] = Integer.parseInt(next);
            }
        }
        treeNode root = myBuildTree(array);
        System.out.println(level(root));
        sc.close();
    }
}
