package cn.qf.taobao.service;

import cn.qf.taobao.pojo.entity.Commodity;
import cn.qf.taobao.pojo.entity.Page;

/**
 * @author dian
 * @date 2020/12/15
 */
public interface CommoditySearchService {
    /**
     * 依价格排序 降序
     * @return 商品信息
     */
    //List<Commodity> searchByPriceDesc(int page,int pageSize);

    /**
     * 依价格排序 升序
     * @return 商品信息
     */
    //List<Commodity> searchByPriceAsc();

    /**
     * 依销量降序排序
     * @return 商品信息
     */
    //List<Commodity> searchBySaleCount();

    /**
     * 关键字查询
     * @param searchContent 传递关键字
     * @return 商品信息列表
     */
    //List<Commodity> searchByKeyWord(String searchContent);

    /**
     * 搜索关键字分页查询
     * @param searchContent 关键字
     * @param currentPage   当前页
     * @return 分页查询列表
     */
    Page<Commodity> searchByKeyWord(String searchContent, int currentPage);

    /**
     * 依价格降序排序分页查询
     * @param currentPage 当前页
     * @return 分页查询列表
     */
    Page<Commodity> searchByPriceDesc(int currentPage);

    /**
     * 依价格升序排序分页查询
     * @param currentPage 当前页
     * @return 分页查询列表
     */
    Page<Commodity> searchByPriceAsc(int currentPage);

    /**
     * 依销售量分页查询
     * @param currentPage 当前页
     * @return 分页查询列表
     */
    Page<Commodity> searchBySaleCount(int currentPage);
}
