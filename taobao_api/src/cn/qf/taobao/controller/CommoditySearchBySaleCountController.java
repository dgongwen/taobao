package cn.qf.taobao.controller;

import cn.qf.taobao.pojo.entity.Commodity;
import cn.qf.taobao.service.CommoditySearchService;
import cn.qf.taobao.service.impl.CommoditySearchServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author dian
 * @date 2020/12/16
 */
@WebServlet("/commoditySearchBySaleCount.t")
public class CommoditySearchBySaleCountController extends BaseController{
    private CommoditySearchService commoditySearchService = new CommoditySearchServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sortByPriceDesc(req,resp);
    }

    private void sortByPriceDesc(HttpServletRequest req, HttpServletResponse resp) {
        String currentpage = req.getParameter("currentpage");
        int currentPage = Integer.parseInt(currentpage);
        try {
            List<Commodity> commodities = commoditySearchService.searchBySaleCount(currentPage);
            writerSuccessResult(commodities,resp);
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
