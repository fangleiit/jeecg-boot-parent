package org.jeecg.fangyou.test;

public class AccessMain {
    public static void main(String[] args) {
        //final修饰的为常量不能第二次赋值
        //3.14位字面常量
        final double PI = 3.1415;
        AccessVo avo = null;
        avo.setAddress("洛阳");
        
    }
}
