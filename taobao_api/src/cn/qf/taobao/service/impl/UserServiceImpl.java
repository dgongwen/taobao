package cn.qf.taobao.service.impl;

import cn.qf.taobao.dao.UserDao;
import cn.qf.taobao.dao.impl.UserDaoImpl;
import cn.qf.taobao.pojo.entity.User;
import cn.qf.taobao.service.UserService;

public class UserServiceImpl implements UserService {

   private   UserDao userDao = new UserDaoImpl();

    @Override
    public User userSelectService(String userName,String password) {

        User user = userDao.userSelect(userName);
        if (user==null){

            throw new RuntimeException("用户名不存在");
        }
        if (!user.getPassword().equals(password)){
            throw new RuntimeException("用户名密码错误");
        }
        return user;


    }
}
