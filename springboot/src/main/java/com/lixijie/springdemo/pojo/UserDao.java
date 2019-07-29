package com.lixijie.springdemo.pojo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Null 被注释的元素必须为 null
 * @NotNull 被注释的元素必须不为 null
 * @AssertTrue 被注释的元素必须为 true
 * @AssertFalse 被注释的元素必须为 false
 * @Min(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @Max(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @DecimalMin(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @DecimalMax(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @Size(max, min)	被注释的元素的大小必须在指定的范围内
 * @Digits (integer, fraction)    被注释的元素必须是一个数字，其值必须在可接受的范围内
 * @Past 被注释的元素必须是一个过去的日期
 * @Future 被注释的元素必须是一个将来的日期
 * @Pattern(value) 被注释的元素必须符合指定的正则表达式
 * @Pattern(regexp = "")
 * @Email
 *缓存对象必须要实现可序列化
 */
public class UserDao  implements Serializable {

    @Length(min = 2,max = 64)
    private  String id;
    /**
     * 非空校验*/

    @NotBlank
    private  String  name;
    private  int sex;
    @Min(10)
    @Max(80)
    private  int age;

    public  UserDao(String id,String  name,int sex,int age){
        this.age=age;
        this.id=id;
        this.name=name;
        this.sex=sex;
    }

    public UserDao() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
