package com.heima.hello;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        // 打印10行Hello world
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello World!");

        }

        // 生成10行helloworld

        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println("helloworld");
        }
        // 创建一个包含10和个随机数字的数组
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        //输出数组
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }




    }


}
