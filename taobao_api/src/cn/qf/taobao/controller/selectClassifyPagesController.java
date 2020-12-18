package cn.qf.taobao.controller;

import cn.qf.taobao.pojo.entity.Pages;
import cn.qf.taobao.service.CommodityService;
import cn.qf.taobao.service.impl.CommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 查询分类总数，页数
 */
@WebServlet("/classifyPages.t")
public class selectClassifyPagesController extends BaseController{
    private CommodityService commodityService = new CommodityServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pages = req.getParameter("num");
        try {
            Pages pages1 = commodityService.selectClassifyNumService(Long.valueOf(pages));
            writerSuccessResult(pages1,resp);
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
