package cn.qf.taobao.service;

import cn.qf.taobao.pojo.entity.Commodity;

import java.util.List;

/**
 * @author dian
 * @date 2020/12/15
 */
public interface CommoditySearchService {
    /**
     * 依价格排序 降序
     * @return 商品信息
     */
    List<Commodity> searchByPriceDesc(int currentPage);

    /**
     * 依价格排序 升序
     * @return 商品信息
     */
    List<Commodity> searchByPriceAsc(int currentPage);

    /**
     * 依销量降序排序
     * @return 商品信息
     */
    List<Commodity> searchBySaleCount(int currentPage);

    /**
     * 关键字查询
     * @param searchContent 传递关键字
     * @return 商品信息列表
     */
    List<Commodity> searchByKeyWord(String searchContent,int currentPage);
}
