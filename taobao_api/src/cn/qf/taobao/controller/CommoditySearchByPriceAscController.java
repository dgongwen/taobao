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
 * @date 2020/12/15
 */
@WebServlet("/commditySearchByPriceAsc.t")
public class CommoditySearchByPriceAscController extends BaseController {
    private CommoditySearchService commoditySearchService = new CommoditySearchServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");
        //排序
        sortByPriceAsc(req,resp);
    }

    private void sortByPriceAsc(HttpServletRequest req, HttpServletResponse resp) {
        String currentpage = req.getParameter("currentpage");
        int currentPage = Integer.parseInt(currentpage);
        try {
            List<Commodity> commodities = commoditySearchService.searchByPriceAsc(currentPage);
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
