package org.jeecg.fangyou.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jeecg.fangyou.util.MyDataSourceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * 在目标方法执行前后执行
 * 这是一个Spring提供的 AOP程序
 */
@Component
@Aspect
public class MyTransactionAsepct {

    @Autowired
    private DataSource dataSource;

    @Autowired
    MyDataSourceUtils myDataSourceUtils;

    //  @Before()
    //  @After()
    // 指定切入点
    @Around("@annotation(MyTransactional)")
    public Object doTransactional(ProceedingJoinPoint proceedingPoint)
            throws SQLException {
        System.out.println("---- 方法执行前 ---- ");

        Connection conn = myDataSourceUtils.getConnection();
        conn.setAutoCommit(false);//开启事物 设置事物手动提交
        try {
            proceedingPoint.proceed();//调用目标方法 执行UserService类里面的deleteUser方法
            System.out.println("提交");
            conn.commit();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("回滚---");
            conn.rollback();
        }finally {
            System.out.println("方法执行后");
            conn.close();
        }
        return  0;


    }






}
