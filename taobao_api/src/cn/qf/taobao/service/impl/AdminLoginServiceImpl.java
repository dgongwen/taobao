package cn.qf.taobao.service.impl;

import cn.qf.taobao.dao.AdminDao;
import cn.qf.taobao.dao.impl.AdminDaoImpl;
import cn.qf.taobao.pojo.qo.AdminLoginQO;
import cn.qf.taobao.service.AdminLoginService;

/**
 * 管理类的serviceImpl层
 */
public class AdminLoginServiceImpl implements AdminLoginService {
    private AdminDao adminDao = new AdminDaoImpl();

    //判断管理员用户名和密码是否正确
    @Override
    public int selectAdmin(String adminUserName, String adminUserPassword) {
        AdminLoginQO adminLoginQO = adminDao.selectAdmin(adminUserName, adminUserPassword);
        if(adminLoginQO!=null){
            return 1;
        }
        return 0;
    }
}
