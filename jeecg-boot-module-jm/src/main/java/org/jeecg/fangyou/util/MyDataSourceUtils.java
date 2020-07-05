package org.jeecg.fangyou.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * 工具类
 */
@Component //交给Spring托管
public class MyDataSourceUtils {
    Connection conn;

    @Autowired
    DataSource dataSource;


    public Connection getConnection() throws SQLException {
        if(conn == null){
            conn = dataSource.getConnection();
        }
        return conn;

    }


}
