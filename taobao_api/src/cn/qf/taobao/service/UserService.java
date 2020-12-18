package cn.qf.taobao.service;

import cn.qf.taobao.pojo.entity.Address;
import cn.qf.taobao.pojo.entity.User;

import javax.naming.Name;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户处理层
 */
public interface UserService {


    /**
     *用户名查询
     * @return 返回用户对象 抛出异常信息
     */
      User userSelectService(String userName, String password, String Verification, HttpServletRequest req);

    /**
     *用户注册
     * @return
     */
      User userRegisterService(String userName,String password,String Verification,HttpServletRequest req);


    /**
     * 查询用户收获地址
     * @param userId
     * @return
     */
    List<Address> selectUserAddressService(Long userId);

    /**
     *添加用户地址
     * @param address
     * @return
     */
    List<Address> addAddress(Address address);

    /**
     * 删除用户地址
     * @param userId
     * @param addressId
     * @return
     */
    List<Address> deleteAddress(Long userId, Long addressId);
}
