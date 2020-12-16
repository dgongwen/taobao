package cn.qf.taobao.service.impl;

import cn.qf.taobao.dao.UserDao;
import cn.qf.taobao.dao.impl.UserDaoImpl;
import cn.qf.taobao.pojo.entity.User;
import cn.qf.taobao.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        if (!verificationVal.equals(Verification)){
            throw new RuntimeException("验证码错误");

        }
        return user;


    }

    @Override
    public User userRegisterService(String userName, String password, HttpServletRequest req) {
        User user = userDao.userSelect(userName);
        System.out.println("Service"+user);
        Integer integer = userDao.userRegister(userName, password);
        if (user!=null){
            throw new RuntimeException("用户名不可用");
        }
        if (integer!=1){
            throw new RuntimeException("注册失败");
        }
         user = userDao.userSelect(userName);
        return user;
    }
}
