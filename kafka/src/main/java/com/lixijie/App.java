package com.lixijie;

/**
 * Hello world!
 *测试断言
 * 开启方式：
 * 在VM中加 -ea
 */
public class App 
{
    public static void main( String[] args )
    {

        boolean isOk = 1 > 2;
        assert isOk :"程序错误";
        System.out.println( "Hello World!" );
    }
}
