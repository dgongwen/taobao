package cn.qf.taobao.service.impl;

import cn.qf.taobao.dao.UserDao;
import cn.qf.taobao.dao.impl.UserDaoImpl;
import cn.qf.taobao.pojo.entity.Address;
import cn.qf.taobao.pojo.entity.User;
import cn.qf.taobao.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserServiceImpl implements UserService {

   private   UserDao userDao = new UserDaoImpl();

    @Override
    public User userSelectService(String userName, String password, String Verification, HttpServletRequest req) {

        User user = userDao.userSelect(userName);
        if (user==null){
            throw new RuntimeException("用户名不存在");
        }
        if (!user.getPassword().equals(password)){
            throw new RuntimeException("密码错误");
        }
        HttpSession session = req.getSession();
        String verificationVal = (String)session.getAttribute("verification");
        if (!verificationVal.equalsIgnoreCase(Verification)){
            throw new RuntimeException("验证码错误");

        }
        return user;


    }

    @Override
    public User userRegisterService(String userName, String password, String Verification, HttpServletRequest req) {
        /**
         * 先判断注册时的用户名是否可用，如果不可用那就返回提示，
         * 然后判断验证码是否正确，用户名跟验证码都没问题就插入数据库
         */
        User user = userDao.userSelect(userName);
        Integer integer = userDao.userRegister(userName, password);
        if (user!=null){
            throw new RuntimeException("用户名不可用");
        }

        HttpSession session = req.getSession();
        String verificationVal = (String)session.getAttribute("verification");
        // equalsIgnoreCase 不区分大小写
        if (!verificationVal.equalsIgnoreCase(Verification)){
            throw new RuntimeException("验证码错误");

        }
        if (integer!=1){
            throw new RuntimeException("注册失败");
        }
        user = userDao.userSelect(userName);
        return user;
    }

    @Override
    public List<Address> selectUserAddressService(Long userId) {

        List<Address> addresses = userDao.selectUserAddress(userId);
        if (addresses==null){
            throw new RuntimeException("查询收货地址失败");
        }
        return addresses;
    }

    @Override
    public List<Address> addAddress(Address address) {

        int i = userDao.addAddress(address);
        if (i==0){
            throw new RuntimeException("添加用户收获地址失败");
        }

        return  selectUserAddressService(address.getUserId());

    }

    @Override
    public List<Address> deleteAddress(Long userId, Long addressId) {

        int i = userDao.deleteAddress(userId, addressId);
        if (i==0){
            throw new RuntimeException("删除用户地址失败");
        }
       return selectUserAddressService(userId);

    }
}
