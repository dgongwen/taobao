package cn.qf.taobao.controller;

import cn.qf.taobao.service.AdminCommodityService;
import cn.qf.taobao.service.impl.AdminCommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateState.t")
public class AdminUpdateUpSoldCommodityController extends BaseController{
    private AdminCommodityService adminCommodityService = new AdminCommodityServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String commodityState = req.getParameter("commodityState");
        System.out.println(id+" "+commodityState);
        try{
            int ad = adminCommodityService.updateUpSoldCommodity(commodityState,Integer.parseInt(id));
            System.out.println(ad);
            writerSuccessResult(ad,resp);
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