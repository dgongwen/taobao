package cn.qf.taobao.dao;

import cn.qf.taobao.pojo.entity.Classify;
import cn.qf.taobao.pojo.entity.Commodity;

import java.util.List;

public interface CommodityDao {

     /**
      *查询分类商品
      * @return 商品对象 null
      */
     Commodity selectClassifyCommodity(String classifyName);

     /**
      * 分类查询
      * @return 返回所有分类
      */
     List<Classify> selectClassify();

}
