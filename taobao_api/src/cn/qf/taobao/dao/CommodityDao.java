package cn.qf.taobao.dao;

import cn.qf.taobao.pojo.entity.Address;
import cn.qf.taobao.pojo.entity.Classify;
import cn.qf.taobao.pojo.entity.Commodity;
import cn.qf.taobao.pojo.entity.Favorite;

import java.util.List;

/**
 * 商品DAO层
 */
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



     /**
      * 查询随机15个商品
      * @return
      */
     List<Commodity> selectRandomCommodity();

     /**
      * id查询单个商品
      * @return返回商品对象 返回null
      */
      Commodity oneCommodity(Long id);

    /**
     *收藏夹 添加商品
     * @param commodityId
     * @param userId
     * @return
     */
      int addCommodity(Long commodityId,Long userId);

    /**
     * 用户收藏夹
     * @param userId
     * @return  商品集合 null
     */
    List<Commodity> favoriteCommodity(Long userId);

    /**
     * 查询收藏夹商品
     * @return
     */
    Favorite selectFavoriteCommodity(Long commodityId, Long userId);

    /**
     * 删除收藏夹商品
     * @param commodityId
     * @param userId
     * @return
     */
     int deleteFavoriteCommodity(Long commodityId, Long userId);

    /**
     * 足迹添加
     * @param commodityId
     * @param userId
     * @return
     */
     int addFootprint(Long commodityId, Long userId);

    /**
     * 查询足迹是否存在
     * @param commodityId
     * @param userId
     * @return
     */
    Favorite existFootprint(Long commodityId, Long userId);

    /**
     * 删除足迹
     * @param commodityId
     * @param userId
     * @return
     */
     int  deleteFootprint(Long commodityId, Long userId);
    /**
     *查询足迹
     * @param userId
     * @return
     */
    List<Commodity> selectFootprint(Long userId);

    /**
     * 添加购物车
     * @return
     */
    int addShopCat(Long commodityId, Long userId,Long num,Double Prices);

    /**
     * 查询购物车
     * @param userId
     * @return
     */
    List<Commodity> selectShopCat(Long userId);

    /**
     * 查询购物车是否有此商品
     * @param commodityId
     * @param userId
     * @return
     */
    Favorite existShopCat(Long commodityId, Long userId);

    /**
     * 删除购物车
     * @param commodityId
     * @param userId
     * @return
     */
    int deleteShopCat(Long commodityId, Long userId);


    /**
     * 查询分类商品
     * @param classifyId
     * @return
     */
    List<Commodity> selectClassifyCommodityId(Long classifyId,Long pages);

    /**
     * 分类销量查询
     * @param classifyId
     * @return
     */
    List<Commodity>  salesClassifyCommodity(Long classifyId,Long pages);

    /**
     * 价格 降序
     * @param classifyId
     * @param pages
     * @return
     */
    List<Commodity> priceBigClassifyCommodity(Long classifyId,Long pages);

    /**
     * 价格升序
     * @param classifyId
     * @param pages
     * @return
     */
    List<Commodity> priceSmallClassifyCommodity(Long classifyId,Long pages);
    /**
     * 查询分类数量
     * @param classifyId
     * @return
     */
    Object selectClassifyNum(Long classifyId);











}
