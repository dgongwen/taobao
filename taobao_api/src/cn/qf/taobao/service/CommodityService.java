package cn.qf.taobao.service;

import cn.qf.taobao.pojo.entity.Classify;
import cn.qf.taobao.pojo.entity.Commodity;

import java.util.List;

public interface CommodityService {
    /**
     * 商品分类查询
     * @param classifyName
     * @return 商品对象 抛出异常信息
     */
    Commodity commodityClassifyService(String classifyName);

    /**
     * 分类查询
     * @return分类集合 抛出异常信息
     */
    List<Classify> classifyService();
}
