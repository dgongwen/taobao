package cn.qf.taobao.controller;

import cn.qf.taobao.pojo.entity.Address;
import cn.qf.taobao.service.UserService;
import cn.qf.taobao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 删除收货地址
 */
@WebServlet("/deleteAddress.t")
public class deleteAddressController extends BaseController{
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId1 = req.getParameter("userId");
        String addressId = req.getParameter("addressId");
        try {
            List<Address> addresses = userService.deleteAddress(Long.valueOf(userId1), Long.valueOf(addressId));
            writerSuccessResult(addresses,resp);

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
