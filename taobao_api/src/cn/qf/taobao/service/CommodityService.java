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
     * @return分类商品集合 抛出异常信息
     */
    List<Classify> classifyService();

    /**
     * 随机展示15个商品
     * @return 商品集合 抛出异常信息
     */
    List<Commodity> randomCommodityService();

    /**
     * id查询单个商品
     * @return
     */
    Commodity oneCommodityService(Long id);

    /**
     * 添加收藏夹商品
     * @param commodityId
     * @param userId
     * @return
     */
    boolean addCommodityService(Long commodityId,Long userId);

    /**
     * 用户收藏夹
     * @param userId
     * @return 商品集合 抛出异常
     */
    List<Commodity> favoriteCommodityService(Long userId);

    /**
     * 删除收藏夹商品
     * @param commodityId
     * @param userId
     * @return
     */
    boolean deleteFavoriteCommodityService(Long commodityId, Long userId);

    /**
     * 足迹
     * @param commodityId
     * @param userId
     * @return
     */
    boolean addFootprint(Long commodityId, Long userId);

    /**
     * 查询足迹
     * @param userId
     * @return
     */
   List<Commodity> selectFootprint(Long userId);

    /**
     *添加购物车
     * @return
     */
    boolean addShopCatService(Long commodityId,Long userId,Long num);

    /**
     * 查询购物车
     * @param userId
     * @return
     */
    List<Commodity> selectShopCatService(Long userId);

    /**
     * 分类上商品查询
     * @param classifyId
     * @return
     */
    List<Commodity> selectClassifyCommodityIdService(Long classifyId);


}
