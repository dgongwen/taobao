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
@WebServlet("/register.t")
public class UserRegisterController extends BaseController{
    // 调用Service层传参过去进行逻辑判断跟操作执行
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取前端参数然后转换成对象
        User use = convertParamsToEntity(req, User.class);
        System.out.println(use);
        try {
            // 将对象返回前端并将用户信息保存到session
            User user = userService.userRegisterService(use.getUserName(), use.getPassword(),use.getVerification(),req);
            HttpSession session = req.getSession();
            session.setAttribute("seller",user);
            writerSuccessResult(user,resp);
        }catch (RuntimeException e){
            // 将错误信息传递出去
            String message = e.getMessage();
            writerErrorResult(message,resp);
        }
    }
    // 因为前端请求是POST所以在POST里面调用GET方法
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
