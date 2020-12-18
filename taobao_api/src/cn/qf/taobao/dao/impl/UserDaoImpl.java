package cn.qf.taobao.dao.impl;

import cn.qf.taobao.dao.UserDao;
import cn.qf.taobao.pojo.entity.Address;
import cn.qf.taobao.pojo.entity.User;
import cn.qf.taobao.util.DruidUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

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
    public Integer userRegister(String userName, String password) {
        // 将数据插入数据库
        String sql = "INSERT INTO `taobao`.`t_user`( `user_name`, `password`) VALUES ( ? , ? )";
        try {
            // 返回受影响行数
            return  queryRunner.update(sql,userName,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Address> selectUserAddress(Long userId) {
        String sql="SELECT * FROM address WHERE user_id=?";
        //开启下划线->驼峰转换所用
        BeanProcessor bean = new GenerousBeanProcessor();
        RowProcessor processor = new BasicRowProcessor(bean);
        BeanListHandler<Address> addressBeanListHandler = new BeanListHandler<>(Address.class,processor);

        try {
            return   queryRunner.query(sql,addressBeanListHandler,userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addAddress(Address address) {

        String sql="INSERT INTO `taobao`.`address`(`address_id`, `user_id`, `consignee_name`, `consignee_phone`, `consignee_address`, `status`) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            return  queryRunner.update(sql,address.getAddressId(),address.getUserId(),address.getConsigneeName(),address.getConsigneePhone(),address.getConsigneeAddress(),address.getStatus());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteAddress(Long userId, Long addressId) {
        String sql="DELETE FROM address WHERE address_id=? AND user_id=?";
        try {
           return queryRunner.update(sql,addressId,userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
