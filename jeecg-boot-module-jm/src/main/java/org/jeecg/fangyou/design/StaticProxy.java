package org.jeecg.fangyou.design;


/**
 * 设计模式静态代理模式
 * 1.创建接口
 * 2.创建真实角色继承接口
 * 3.创建代理角色继承接口、引用真实角色
 */
public class StaticProxy {
    public static void main(String[] args) {
        Merry me = new Me();
        Medium medium = new Medium(me);
        medium.merry();

    }
}


interface  Merry{
    void merry(); //默认为 public abstract void merry();
}

//真实角色
class Me implements  Merry{
    @Override
    public void merry() {
        System.out.println("和心爱的人结婚 ...");
    }
}

//代理角色
class Medium implements Merry{
    private Merry me;
    public Medium(){
    }
    public Medium(Merry me){
        this.me = me;
    }

    void before(){
        System.out.println("布置婚房...");
    }

    void after(){
        System.out.println("闹伴娘...");
    }

    @Override
    public void merry() {
        before();
        me.merry();
        after();
    }
}



