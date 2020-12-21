package cn.qf.taobao.controller;
import cn.qf.taobao.pojo.entity.Indent;
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
import java.util.List;

/**
 * 用户订单展示
 */

@WebServlet("/indentList.t")
public class IndentListController extends HttpServlet {
        IndentService indentService = new IndentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Indent> list = indentService.indentList();
        Send<List<Indent>> integerSend = null;
        if(list!=null){
            //成功
            integerSend = Send.sendJsonSucess(list);
            DbFormat.format(resp, integerSend);
            System.out.println("查询成功");
        }else{
            //失败
            integerSend = Send.sendJsonError(null);
            DbFormat.format(resp, integerSend);
            System.out.println("查询失败");
        }

    }
}
