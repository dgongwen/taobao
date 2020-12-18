package cn.qf.taobao.controller;

import cn.qf.taobao.pojo.entity.Commodity;
import cn.qf.taobao.service.CommodityService;
import cn.qf.taobao.service.impl.CommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 分类商品查询
 */
@WebServlet("/commodityClassify.t")
public class CommodityClassifyController extends BaseController{
    private  CommodityService commodityService = new CommodityServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String classify = req.getParameter("classify");
        try {
            Commodity commodity = commodityService.commodityClassifyService(classify);
            writerSuccessResult(commodity,resp);

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
