package cn.qf.taobao.controller;
import cn.qf.taobao.pojo.entity.Indent;
import cn.qf.taobao.pojo.qo.IndentRequest;
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
 * create订单
 * 1,set 收货人,号码,地址,总金额
 * 2,总金额(商品单价*数量),判断单价是否发生改变,判断库存是否足够
 */

@WebServlet("/indent.t")
public class IndentController extends HttpServlet {
IndentService indentService = new IndentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String receiverName = req.getParameter("receiverName");
        String receiverPhone = req.getParameter("receiverPhone");
        String receiverAddress = req.getParameter("receiverAddress");
        String Id = req.getParameter("id");
        //String commodityPrice = req.getParameter("commodityPrice");
        String commodityNum = req.getParameter("commodityNum");
        String commodityName = req.getParameter("commodityName");
        long Ids = Integer.parseInt(Id);
        //double commodityPrices = Double.parseDouble(commodityPrice);
        long commodityNums = Integer.parseInt(commodityNum);
        IndentRequest indentRequest = new IndentRequest(commodityName,receiverName,receiverPhone,receiverAddress,Ids,commodityNums);
        List<Indent> list = indentService.addIndent(indentRequest);
        Send<List<Indent>> integerSend = null;
        if(list!=null){
            //成功
            integerSend = Send.sendJsonSucess(list);
            DbFormat.format(resp, integerSend);
            System.out.println("订单创建成功");
        }else{
            //失败
            integerSend = Send.sendJsonError(null);
            DbFormat.format(resp, integerSend);
            System.out.println("订单创建失败");
        }
    }
}
