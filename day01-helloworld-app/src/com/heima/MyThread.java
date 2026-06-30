package com.heima;
/*
1.让子类继承Thread线程类
 */
public class MyThread extends Thread{
    //2.必须重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程输出："+ i);
        }
    }
}

