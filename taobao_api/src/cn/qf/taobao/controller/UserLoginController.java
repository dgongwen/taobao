package cn.qf.taobao.controller;

import cn.qf.taobao.pojo.entity.User;
import cn.qf.taobao.service.UserService;
import cn.qf.taobao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//登录
@WebServlet("/login.t")
public class UserLoginController extends BaseController{
    private   UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User use = convertParamsToEntity(req, User.class);
        try {
            User user = userService.userSelectService(use.getUserName(), use.getPassword(),use.getVerification(),req);
            HttpSession session = req.getSession();
            session.setAttribute("seller",user);
            writerSuccessResult(user,resp);
        }catch (RuntimeException e){
            String message = e.getMessage();
           writerErrorResult(message,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
