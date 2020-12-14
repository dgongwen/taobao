package cn.qf.taobao.service;

import cn.qf.taobao.pojo.entity.User;

/**
 * 用户处理层
 */
public interface UserService {


    /**
     *用户名查询
     * @return 返回用户对象 抛出异常信息
     */
      User userSelectService(String userName, String password);
}
