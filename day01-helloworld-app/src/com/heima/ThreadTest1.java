package com.heima;
/*

 */
public class ThreadTest1 {
    //3.创建MyThread类型的对象代表一个子线程
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程输出："+ i);
        }
    }
}
