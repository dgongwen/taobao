package cn.qf.taobao.service;

import cn.qf.taobao.pojo.entity.User;

import javax.naming.Name;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户处理层
 */
public interface UserService {


    /**
     *用户名查询
     * @return 返回用户对象 抛出异常信息
     */
      User userSelectService(String userName, String password, String Verification, HttpServletRequest req);

      User userRegisterService(String userName,String password,HttpServletRequest req);
}
