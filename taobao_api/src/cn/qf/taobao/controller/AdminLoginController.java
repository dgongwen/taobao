package cn.qf.taobao.controller;

import cn.qf.taobao.pojo.qo.AdminLoginQO;
import cn.qf.taobao.service.AdminLoginService;
import cn.qf.taobao.service.impl.AdminLoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 管理员登录Servlet
 */
@WebServlet("/adminLogin")
public class AdminLoginController extends BaseController {
    private AdminLoginService adminLoginService = new AdminLoginServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminLoginQO adminLoginQO = convertParamsToEntity(req,AdminLoginQO.class);
        System.out.println(adminLoginQO.getAdminUserName()+"    "+adminLoginQO.getAdminUserPassword());
        try{
            int admin = adminLoginService.selectAdmin(adminLoginQO.getAdminUserName(),adminLoginQO.getAdminUserPassword());
            System.out.println(admin);
            writerSuccessResult(admin,resp);
        }catch (RuntimeException e){
            String message = e.getMessage();
            System.out.println(message);
            writerErrorResult(message,resp);
            }
        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
