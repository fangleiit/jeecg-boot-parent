package org.jeecg.fangyou.test;

public class AccessVo {

    private String name;
    private Integer age;

    private static String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        AccessVo.address = address;
    }
}
