package cn.qf.taobao.dao;
import cn.qf.taobao.pojo.entity.Commodity;
import cn.qf.taobao.pojo.entity.Indent;
import java.util.List;

public interface IndentDao {

    //创建订单
    int createIndent(Indent indent);

    //查询商品单价
    Commodity selectPrice(Long productId);

    //查询订单更新数据,返回用户
    List<Indent> selectIndent(String snow);

    //取消订单
    int updateIndent(long indentIds);

    //查询订单
    List<Indent> selectById();
}
