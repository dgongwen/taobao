package cn.qf.taobao.controller;

import cn.qf.taobao.pojo.entity.Commodity;
import cn.qf.taobao.pojo.entity.Page;
import cn.qf.taobao.service.CommoditySearchService;
import cn.qf.taobao.service.impl.CommoditySearchServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dian
 * @date 2020/12/16
 */
@WebServlet("/commoditySearchBySaleCount")
public class CommoditySearchBySaleCountController extends BaseController {
    private CommoditySearchService commoditySearchService = new CommoditySearchServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");
        sortByPriceDesc(req,resp);
    }

    private void sortByPriceDesc(HttpServletRequest req, HttpServletResponse resp) {
        String currentPage = req.getParameter("currentPage");
        int pageCount = 1;
        if(currentPage != null){
            pageCount = Integer.parseInt(currentPage);
        }
        try {
            Page<Commodity> commodityPage = commoditySearchService.searchBySaleCount(pageCount);
            writerSuccessResult(commodityPage,resp);
        } catch (Exception e) {
            String message = e.getMessage();
            writerErrorResult(message,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
