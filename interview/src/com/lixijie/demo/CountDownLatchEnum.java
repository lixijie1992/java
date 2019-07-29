package com.lixijie.demo;

/**
 * CountDownLatch采用枚举的例子
 */
public enum CountDownLatchEnum {
    CHU(1,"楚国","2333"),QIN(2,"秦国","f34"),
    HAN(3,"韩国","f34"),ZHOU  (4,"周国","f34"),鲁(5,"鲁国","f34");
    private  int num;
    private  String value;
    private  String descr;

    CountDownLatchEnum(int num, String value, String descr) {
        this.num = num;
        this.value = value;
        this.descr = descr;
    }

    public int getNum() {
        return num;
    }

    public String getValue() {
        return value;
    }

    public String getDescr() {
        return descr;
    }

    public static CountDownLatchEnum findVaule(int id){
        for (CountDownLatchEnum countDownLatchEnum :CountDownLatchEnum.values()){
            if(countDownLatchEnum.getNum()==id){
                return countDownLatchEnum;
            }
        }
        return null;
    }


}
