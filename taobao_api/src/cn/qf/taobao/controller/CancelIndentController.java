package cn.qf.taobao.controller;
import cn.qf.taobao.service.IndentService;
import cn.qf.taobao.service.impl.IndentServiceImpl;
import cn.qf.taobao.util.DbFormat;
import cn.qf.taobao.util.Send;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 取消订单
 */

@WebServlet("/cancelIndent.t")
public class CancelIndentController extends HttpServlet {
IndentService indentService = new IndentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String indentId = req.getParameter("indentId");
        long indentIds = Integer.parseInt(indentId);
        int i = indentService.cancelIndent(indentIds);
        Send<Integer> integerSend = null;
        if(i>0){
            //成功
            integerSend = Send.sendJsonSucess(i);
            DbFormat.format(resp, integerSend);
            System.out.println("订单删除成功");
        }else{
            //失败
            integerSend = Send.sendJsonError(null);
            DbFormat.format(resp, integerSend);
            System.out.println("订单删除失败");
        }
    }
}
