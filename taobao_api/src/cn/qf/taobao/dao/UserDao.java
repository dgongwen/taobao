package cn.qf.taobao.dao;

import cn.qf.taobao.pojo.entity.Address;
import cn.qf.taobao.pojo.entity.User;

import java.util.List;

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

    /**
     * 查询用户地址
     * @param userId
     * @return
     */
    List<Address> selectUserAddress(Long userId);

    /**
     * 添加用户地址
     * @param address
     * @return
     */
    int addAddress(Address address);

    /**
     * 删除收货地址
     * @param userId
     * @param addressId
     * @return
     */
    int deleteAddress(Long userId,Long addressId);
}
