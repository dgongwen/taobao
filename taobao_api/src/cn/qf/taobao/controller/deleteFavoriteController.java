package cn.qf.taobao.controller;

import cn.qf.taobao.service.CommodityService;
import cn.qf.taobao.service.impl.CommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除收藏夹商品
 */
@WebServlet("/deleteFavorite.t")
public class deleteFavoriteController extends BaseController{
    private CommodityService commodityService = new CommodityServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String commodityId1 = req.getParameter("commodityId");
        String userId = req.getParameter("userId");
        try {
            boolean b = commodityService.deleteFavoriteCommodityService(Long.valueOf(commodityId1), Long.valueOf(userId));
            writerSuccessResult("",resp);
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
