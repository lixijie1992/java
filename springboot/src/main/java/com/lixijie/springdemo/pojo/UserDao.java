package com.lixijie.springdemo.pojo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Null ��ע�͵�Ԫ�ر���Ϊ null
 * @NotNull ��ע�͵�Ԫ�ر��벻Ϊ null
 * @AssertTrue ��ע�͵�Ԫ�ر���Ϊ true
 * @AssertFalse ��ע�͵�Ԫ�ر���Ϊ false
 * @Min(value) ��ע�͵�Ԫ�ر�����һ�����֣���ֵ������ڵ���ָ������Сֵ
 * @Max(value) ��ע�͵�Ԫ�ر�����һ�����֣���ֵ����С�ڵ���ָ�������ֵ
 * @DecimalMin(value) ��ע�͵�Ԫ�ر�����һ�����֣���ֵ������ڵ���ָ������Сֵ
 * @DecimalMax(value) ��ע�͵�Ԫ�ر�����һ�����֣���ֵ����С�ڵ���ָ�������ֵ
 * @Size(max, min)	��ע�͵�Ԫ�صĴ�С������ָ���ķ�Χ��
 * @Digits (integer, fraction)    ��ע�͵�Ԫ�ر�����һ�����֣���ֵ�����ڿɽ��ܵķ�Χ��
 * @Past ��ע�͵�Ԫ�ر�����һ����ȥ������
 * @Future ��ע�͵�Ԫ�ر�����һ������������
 * @Pattern(value) ��ע�͵�Ԫ�ر������ָ����������ʽ
 * @Pattern(regexp = "")
 * @Email
 *����������Ҫʵ�ֿ����л�
 */
public class UserDao  implements Serializable {

    @Length(min = 2,max = 64)
    private  String id;
    /**
     * �ǿ�У��*/

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
