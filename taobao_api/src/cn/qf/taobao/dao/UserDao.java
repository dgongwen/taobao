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
     * 查询用户所有地址
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

    /**
     * 查询单个地址
     * @param addressId
     * @return
     */
     Address selectOneAddress(Long userId,Long addressId);

    /**
     * 查询用户默认地址
     * @param userId
     * @return
     */
    Address selectDefaultAddress(Long userId);

    /**
     * 修改收货地址为默认地址
     * @param userId
     * @param addressId
     * @return
     */
     int modifyOneAddress(Long userId,Long addressId);

    /**
     * |修改其他收货地址为非默认地址
     * @param userId
     * @param addressId
     * @return
     */
     int modifyAllAddress(Long userId,Long addressId);


}
