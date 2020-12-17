package cn.qf.taobao.controller;

import cn.qf.taobao.pojo.qo.AdminCommodityQO;
import cn.qf.taobao.service.AdminCommodityService;
import cn.qf.taobao.service.impl.AdminCommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateById.t")
public class AdminUpdateCommodityByIdController extends BaseController{
    private AdminCommodityService adminCommodityService = new AdminCommodityServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminCommodityQO adminCommodityQO = convertParamsToEntity(req,AdminCommodityQO.class);
        System.out.println(adminCommodityQO);
        try{
            int ad = adminCommodityService.updateAdminCommodityById(adminCommodityQO.getId(),adminCommodityQO.getCommodityNum(),adminCommodityQO.getCommodityName(),adminCommodityQO.getCommodityPrice(),adminCommodityQO.getCommodityImgUrl(),adminCommodityQO.getClassificationId(),adminCommodityQO.getCommodityState());
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
