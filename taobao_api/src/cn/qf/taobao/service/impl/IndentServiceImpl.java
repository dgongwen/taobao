package cn.qf.taobao.service.impl;
import cn.qf.taobao.dao.IndentDao;
import cn.qf.taobao.dao.impl.IndentDaoImpl;
import cn.qf.taobao.pojo.entity.Commodity;
import cn.qf.taobao.pojo.entity.Indent;
import cn.qf.taobao.pojo.qo.IndentRequest;
import cn.qf.taobao.service.IndentService;
import cn.qf.taobao.util.SnowflakeIdUtils;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 订单创建
 */

public class IndentServiceImpl implements IndentService {
    IndentDao indentDao  = new IndentDaoImpl();

    @Override
    public List<Indent> addIndent(IndentRequest indentRequest) {
        //雪花算法得到订单编号
        String snow = new SnowflakeIdUtils(3, 1).nextId()+"";
        //得到订单创建时间
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        //设置订单参数
        Indent indent = new Indent();
        //订单创建时间
        indent.setCreateTime(dateFormat.format(date));
        //订单编号
        indent.setIndentSn(snow);
        //收货人
        indent.setReceiverName(indentRequest.getReceiverName());
        //收货号码
        indent.setReceiverPhone(indentRequest.getReceiverPhone());
        //收货地址
        indent.setReceiverAddress(indentRequest.getReceiverAddress());
        //商品数量
        indent.setCommodityNumber(indentRequest.getCommodityNum());
        //商品名
        indent.setCommodityName(indentRequest.getCommodityName());
        //设置订单总金额(单价*数量)(判断单价是否发生改变,库存数量是否足够)
        //查询商品单价,库存
        Commodity product = indentDao.selectPrice(indentRequest.getId());
        //添加图片
        indent.setCommodityImgUrl(product.getCommodityImgUrl());

       /* //判断单价是否改变
        if(isPrice(product,indentRequest)){
            throw new RuntimeException("价格发生改变,请重新下单");
        }*/

        //判断商品数量是否足够
        if(isNum(product,indentRequest)){
            throw new RuntimeException("库存不足,请重新下单");
        }

        //计算总金额
        BigDecimal bigDecimal = new BigDecimal(0);
        long productNum = indentRequest.getCommodityNum();
        double productPrice = product.getCommodityPrice();
        BigDecimal Decimal = new BigDecimal(productNum);
        BigDecimal multiply = Decimal.multiply(new BigDecimal(productPrice));
        bigDecimal = bigDecimal.add(multiply);

        //设置总金额
        indent.setTotalAmount(bigDecimal);

        //将所有设置的参数,判断过的参数,添加进订单
        int indent1 = indentDao.createIndent(indent);
        List<Indent> list = null;
        if(indent1>0){
            //添加成功,查询返回订单数据展示,用户确认
             list = indentDao.selectIndent(snow);
        }else{
            throw new RuntimeException("订单创建失败");
        }
        return list;
    }


    //取消订单
    @Override
    public int cancelIndent(long indentIds) {
        return indentDao.updateIndent(indentIds);
    }

    //查询订单
    @Override
    public List<Indent> indentList() {
        return indentDao.selectById();
    }

    /**
     * 判断商品数量是否足够
     *  return false,不够
     *  return true,足够
     * @param product
     * @param indentRequest
     * @return
     */

    private boolean isNum(Commodity product, IndentRequest indentRequest) {
        if(product.getCommodityNum()<indentRequest.getCommodityNum()){
            return true;
        }

       return false;
    }


  /*  *//**
     * 判断单价是否改变
     * return false,价格发生改变
     * return true,价格不变
     * @param product
     * @param indentRequest
     * @return
     *//*

    private boolean isPrice(Commodity product,IndentRequest indentRequest) {
        if(product.getCommodityPrice()!=indentRequest.getCommodityPrice()){
            return false;
        }
        return true;

    }*/
}
