package cn.qf.taobao.dao;

import cn.qf.taobao.pojo.entity.User;

/**
 * 用户DAO
 */
public interface UserDao {

    /**
     * 用户名查询
     * @return 返回用户对象 null
     */
    User userSelect(String userName);

    /**
     * 用户注册
     * @param userName
     * @param password
     * @return
     */
    Integer userRegister(String userName,String password);
}
