package com.lixijie.swordoffer;

import java.util.Arrays;

/**
 * 请实现一个函数，
 * 将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpaceDemo {
    public StringBuffer replaceSpace(StringBuffer target) {
        StringBuffer ss = new StringBuffer();
        int len = target.length() - 1;
        for (int i = len; i >= 0; i--) {
            if (' '==target.charAt(i)) {
                ss.append("02%");
            } else {
                ss.append(target.charAt(i));
            }
        }
        return ss;
    }

    public static void main(String[] args) {
        ReplaceSpaceDemo replaceSpaceDemo =new ReplaceSpaceDemo();
        StringBuffer str = new StringBuffer("qweqw  wqeqw  weq ");
        System.out.println(replaceSpaceDemo.replaceSpace(str));
    }
}
