package com.lixijie.swordoffer;

/**
 * 大家都知道斐波那契数列，
 * 现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class FibonacciDemo {
    public int Fibonacci(int n) {
        int[] tt = new int[n+1];
        tt[0]=0;
        tt[1]=1;
        if (n == 0 || n == 1)
            return n;
        int fn1 = 0;
        int fn2 = 1;
        for (int i = 2; i <= n; i++) {
            /*当前项改变*/
            fn2 += fn1;
            tt[i]=fn2;
            /*当前项的前一项改变*/
            fn1 = fn2 - fn1;
        }
        for (int i = 0; i <tt.length ; i++) {
            System.out.print(tt[i]);
            System.out.print("*");
        }

        return fn2;
    }


    /**
     * 一只青蛙，跳上台阶，一次可以跳一阶，
     * 或者一次跳两阶，
     * 问跳跃50阶台阶有多少种跳法？
     * @param target
     * @return
     */
    public long JumpFloor(long target) {

        if(target==1)
            return 1;
        if(target==2)
            return 2;

        long a = 2;
        long b = 1;
        long sum = 0;
        for(long i=3;i<=target;i++){
            sum = a + b;
           // b = a;
            a = sum;
            b=sum-b;
        }
        return sum;
    }

    public static void main(String[] args) {
        FibonacciDemo FibonacciDemo = new FibonacciDemo();
        System.out.println("-8-"+FibonacciDemo.Fibonacci(50));
        System.out.println("-9-"+FibonacciDemo.JumpFloor(50));
    }
}
