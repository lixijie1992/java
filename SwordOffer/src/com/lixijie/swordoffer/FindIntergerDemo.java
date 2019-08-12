package com.lixijie.swordoffer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindIntergerDemo {
    public  boolean  findInterger(int[][] arrays ,int target) {

        if (arrays.length == 0 || arrays[0].length == 0) {
            return false;
        }
        int m = arrays[0].length - 1;
        int n = 0;
        int temp = arrays[n][m];
        /*向左向右增大缩小不能相同*/
        /*二维数组是有序的，从右上角来看，向左数字递减，向下数字递增。
        因此从右上角开始查找，
        当要查找数字比右上角数字大时，下移；
        当要查找数字比右上角数字小时，左移；
        如果出了边界，则说明二维数组中不存在该整数*/
        while (target != temp) {
            if (m > 0 && n < arrays[0].length - 1) {
                if (target > temp) {
                    /*目标比当前列的最小值大，就往下走（增大的方向） */
                    n = n + 1;
                } else if (target < temp) {
                    /*目标比当前列的最小值小，就往左走（缩小的方向）*/
                    m = m - 1;
                }
                temp = arrays[n][m];
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindIntergerDemo s = new FindIntergerDemo();
        int[][] arrays={{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8}};
        int target=4;
        System.out.println(s.findInterger(arrays,target));

    }
}
