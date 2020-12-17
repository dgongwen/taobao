package cn.qf.taobao.service;

import cn.qf.taobao.pojo.qo.AdminLoginQO;

/**
 * 管理类的service层
 */
public interface AdminLoginService {
    /**
     * （登录功能）判断管理员用户名和密码是否正确
     * @param adminUserName  管理员名
     * @param adminUserPassword   管理员密码
     * @return
     */
    int selectAdmin(String adminUserName, String adminUserPassword);




}
