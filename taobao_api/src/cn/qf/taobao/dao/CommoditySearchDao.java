package cn.qf.taobao.dao;

import cn.qf.taobao.pojo.entity.Commodity;

import java.util.List;

/**
 * @author dian
 * @date 2020/12/15
 */
public interface CommoditySearchDao {
    /**
     * 通用查询总条数
     * @return 总条数
     */
    Long searchCount();

    /**
     * 依价格排序 降序
     * @return 商品信息
     */
    List<Commodity> searchByPriceDesc(int page, int pageSize);


    /**
     * 依价格排序 升序
     * @return 商品信息
     */
    List<Commodity> searchByPriceAsc(int page,int pageSize);

    /**
     * 依销量降序排序
     * @return 商品信息
     */
    List<Commodity> searchBySaleCount(int page,int pageSize);

    /**
     * 关键字查询
     * @param searchContent 传递关键字
     * @return 商品信息列表
     */
    List<Commodity> searchByKeyWord(String searchContent,int page,int pageSize);

    Long searchByWordCount(String searchContent);




}
