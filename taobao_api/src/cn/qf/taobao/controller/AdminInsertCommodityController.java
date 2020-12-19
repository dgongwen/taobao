package cn.qf.taobao.controller;

import cn.qf.taobao.pojo.qo.AdminCommodityQO;
import cn.qf.taobao.service.AdminCommodityService;
import cn.qf.taobao.service.impl.AdminCommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insertCommodity.d")
public class AdminInsertCommodityController extends BaseController{
    private AdminCommodityService adminCommodityService = new AdminCommodityServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commodityNum = req.getParameter("commodityNum");
        String commodityName = req.getParameter("commodityName");
        String commodityPrice = req.getParameter("commodityPrice");
        String commodityImgUrl = req.getParameter("commodityImgUrl");
        String classificationId = req.getParameter("classificationId");
        String commodityState = req.getParameter("commodityState");
        System.out.println(commodityNum+" "+commodityName+" "+commodityPrice+" "+commodityImgUrl+" "+classificationId+" "+commodityState);

        try{
            int ad = adminCommodityService.insertAdminCommodity(commodityNum,commodityName,Double.parseDouble(commodityPrice),commodityImgUrl,Integer.parseInt(classificationId),commodityState);
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
