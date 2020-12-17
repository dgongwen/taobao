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

}