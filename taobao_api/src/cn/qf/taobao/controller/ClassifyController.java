package cn.qf.taobao.controller;

import cn.qf.taobao.pojo.entity.Classify;
import cn.qf.taobao.service.CommodityService;
import cn.qf.taobao.service.impl.CommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 分类查询
 */
@WebServlet("/classify.t")
public class ClassifyController extends BaseController{

    private CommodityService commodityService = new CommodityServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            List<Classify> classifies = commodityService.classifyService();
            writerSuccessResult(classifies,resp);

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
