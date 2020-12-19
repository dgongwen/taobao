package cn.qf.taobao.controller;

import cn.qf.taobao.pojo.entity.Commodity;
import cn.qf.taobao.service.CommodityService;
import cn.qf.taobao.service.impl.CommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 销量分类
 */
@WebServlet("/salesClassify.t")
public class salesClassifyCommodityController extends BaseController{

    private CommodityService commodityService = new CommodityServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classifyId1 = req.getParameter("num");
        String pages = req.getParameter("pages");
        try {
            List<Commodity> commodities = commodityService.salesClassifyCommodityService(Long.valueOf(classifyId1), Long.valueOf(pages));
            writerSuccessResult(commodities,resp);
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
