package cn.qf.taobao.controller;

import cn.qf.taobao.service.CommodityService;
import cn.qf.taobao.service.impl.CommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *足迹添加
 */
@WebServlet("/footprint.t")
public class AddFootprintController extends BaseController{
    private CommodityService commodityService = new CommodityServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String commodityId = req.getParameter("commodityId");
        String userId = req.getParameter("userId");
        try {
            boolean b = commodityService.addFootprint(Long.valueOf(commodityId), Long.valueOf(userId));
            writerSuccessResult("",resp);
        }catch (RuntimeException e){
            String message = e.getMessage();
            writerErrorResult(message,resp);
        }




    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
