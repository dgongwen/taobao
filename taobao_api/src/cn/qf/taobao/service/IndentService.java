package cn.qf.taobao.service;
import cn.qf.taobao.pojo.entity.Indent;
import cn.qf.taobao.pojo.qo.IndentRequest;
import java.util.List;

public interface IndentService {

    //订单创建
    List<Indent> addIndent(IndentRequest indentRequest);

    //订单取消
    int cancelIndent(long indentIds);

    //订单展示
    List<Indent> indentList();
}
