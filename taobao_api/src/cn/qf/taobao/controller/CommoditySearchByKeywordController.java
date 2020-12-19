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
 * @date 2020/12/15
 */
@WebServlet("/commditySearchByKeyword")
public class CommoditySearchByKeywordController extends BaseController {
    private CommoditySearchService commoditySearchService = new CommoditySearchServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");
        //依关键字查询
        searchByKeyword(req, resp);
    }

    private void searchByKeyword(HttpServletRequest req, HttpServletResponse resp) {
        String searchcontent = req.getParameter("searchcontent");
        String currentPage = req.getParameter("currentPage");
        int pageCount = 1;
        System.out.println(currentPage);
        if(currentPage != null){
            pageCount = Integer.parseInt(currentPage);
        }
        System.out.println("=====");
        System.out.println(pageCount);
        try {
            Page<Commodity> commodityPage = commoditySearchService.searchByKeyWord(searchcontent, pageCount);
            System.out.println(commodityPage);
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
