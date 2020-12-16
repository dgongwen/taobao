package cn.qf.taobao.dao.impl;

import cn.qf.taobao.dao.UserDao;
import cn.qf.taobao.pojo.entity.User;
import cn.qf.taobao.util.DruidUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * 用户DAO
 */
public class  UserDaoImpl implements UserDao {
    //创建DBUtil工具
    private  QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
    @Override
    public User userSelect(String userName) {

        String sql="SELECT * FROM t_user WHERE user_name=?";
        //开启下划线->驼峰转换所用
        BeanProcessor bean = new GenerousBeanProcessor();
        RowProcessor processor = new BasicRowProcessor(bean);

        BeanHandler<User> userBeanHandler = new BeanHandler<>(User.class,processor);

        try {
            return  queryRunner.query(sql, userBeanHandler,userName);

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public User userRegister(String userName, String password) {
        String sql = "insert into t_user (user_name,password) values (?, ?)";
        return null;
    }
}
