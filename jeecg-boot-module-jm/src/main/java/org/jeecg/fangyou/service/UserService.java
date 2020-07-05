package org.jeecg.fangyou.service;

import org.jeecg.fangyou.annotation.MyTransactional;
import org.jeecg.fangyou.util.MyDataSourceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;


@Service
public class UserService {
    @Autowired
    MyDataSourceUtils myDataSourceUtils;

    @MyTransactional
    public void deleteUser(String userId) throws SQLException {
            Connection conn = myDataSourceUtils.getConnection();
            Statement stat = conn.createStatement();
            String sql01 = "delete from tb_user u where u.id = '" + userId + "'";
            String sql02 = "insert tb_user ('" + UUID.randomUUID() + " ',' 删除用户: " + userId + "',now())";
            stat.execute(sql01);
            stat.execute(sql02);
//            int i = 1 / 0;
        }
}
