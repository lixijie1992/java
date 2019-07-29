package com.lixijie.demo;

import java.util.Arrays;

public class APP {
    public static void main(String[] args) {
        /*数组初始化三种方式
         * 数组是一个对象，不同类型的数组具有不同的类
         * 数组是一个连续的存储结构
         * 两个数组用Arrays.equals()方法比较时，会逐个便利其中的元素，对每个元素进行比较*/
        int[] ss = new int[10];
        int[] aa = new int[]{3, 4, 5, 6, 7, 8, 9, 0};
        int[] bb = {3, 4, 5, 6, 7, 8, 9, 0};
        int[] ee = {3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(Arrays.equals(aa, bb));
        System.out.println(aa.equals(bb));
        /*当final修饰一个基本数据类型时，表示该基本数据类型的值一旦在初始化后便不能发生变化；
        如果final修饰一个引用类型时，则在对其初始化之后便不能再让其指向其他对象了，
        但该引用所指向的对象的内容是可以发生变化的*/

        /* 位运算：
        *按位与(&)
        参加运算的两个数，换算为二进制(0、1)后，进行与运算。只有当相应位上的数都是1时，该位才取1，否则该为为0
         * 按位或(|)
        参加运算的两个数，换算为二进制(0、1)后，进行或运算。只要相应位上存在1，那么该位就取1，均不为1，即为0。
         * 按位异或(^)
         参加运算的两个数，换算为二进制(0、1)后，进行异或运算。只有当相应位上的数字不相同时，该为才取1，若相同，即为0。
         * 取反(~)
         参加运算的两个数，换算为二进制(0、1)后，进行取反运算。每个位上都取相反值，1变成0，0变成1。
         * 左移(<<)左移一位的结果就是原值乘2，左移两位的结果就是原值乘4。
         * 右移(>>)右移一位的结果就是原值除2，左移两位的结果就是原值除4，注意哦，除了以后没有小数位的，都是取整。
         */

        /*
        * JSP有9个内置对象：
        *- request：封装客户端的请求，其中包含来自GET或POST请求的参数；
        *- response：封装服务器对客户端的响应；
        *- pageContext：通过该对象可以获取其他对象；
        *- session：封装用户会话的对象；
        *- application：封装服务器运行环境的对象；
        *- out：输出服务器响应的输出流对象；
        *- config：Web应用的配置对象；
        *- page：JSP页面本身（相当于Java程序中的this）；
        *- exception：封装页面抛出异常的对象
        */
        int qq =2147483647;
        qq=qq+5;
        System.out.println(qq);
        /*
        * Math.ceil()的英文意义是天花板，该方法就表示向上取整;Math.floor()的英文意义是地板，该方法就表示向下取整；
        *最难掌握的是Math.round()方法，它表示“四舍五入”；
       */
        /*抽象类与普通类的唯一区别就是不能创建实例对象和允许有abstract方法。
        * 接口中定义的变量只能是public static final类型。
        * abstract的method不可以是static的
        *  native方法表示该方法要用另外一种依赖平台的编程语言实现的，不存在着被子类实现的问题，所以，它也不能是抽象的，不能与abstract混用*/


    }
}
