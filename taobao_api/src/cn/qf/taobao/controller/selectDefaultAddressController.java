package cn.qf.taobao.controller;

import cn.qf.taobao.pojo.entity.Address;
import cn.qf.taobao.service.UserService;
import cn.qf.taobao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 查询用户默认地址
 */

@WebServlet("/selectDefaultAddress.t")
public class selectDefaultAddressController extends BaseController{

    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        try {
            Address address = userService.selectDefaultAddressService(Long.valueOf(userId));
            writerSuccessResult(address,resp);
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
