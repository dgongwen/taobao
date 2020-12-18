package cn.qf.taobao.dao;

import cn.qf.taobao.pojo.entity.Commodity;

import java.util.List;

/**
 * @author dian
 * @date 2020/12/15
 */
public interface CommoditySearchDao {
    /**
     * 依价格排序 降序
     * @return 商品信息
     */
    List<Commodity> searchByPriceDesc(int offset, int pageSize);

    /**
     * 依价格排序 升序
     * @return 商品信息
     */
    List<Commodity> searchByPriceAsc(int page, int pageSize);

    /**
     * 依销量降序排序
     * @return 商品信息
     */
    List<Commodity> searchBySaleCount(int page, int pageSize);
    //依评价排序
    //综合排序
    //分页查询
    /**
     * 关键字查询
     * @param searchContent 传递关键字
     * @return 商品信息列表
     */
    List<Commodity> searchByKeyWord(String searchContent,int page, int pageSize);



}
