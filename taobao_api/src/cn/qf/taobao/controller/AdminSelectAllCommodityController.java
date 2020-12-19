package cn.qf.taobao.controller;

import cn.qf.taobao.pojo.qo.AdminCommodityQO;
import cn.qf.taobao.service.AdminCommodityService;
import cn.qf.taobao.service.impl.AdminCommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAll.d")
public class AdminSelectAllCommodityController extends BaseController{
    private AdminCommodityService adminCommodityService = new AdminCommodityServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminCommodityQO adminCommodityQO = convertParamsToEntity(req,AdminCommodityQO.class);
        try{
            List<AdminCommodityQO> ad =  adminCommodityService.selectAdminCommodityService();
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
