package cn.qf.taobao.service.impl;

import cn.qf.taobao.dao.CommodityDao;
import cn.qf.taobao.dao.impl.CommodityDaoImpl;
import cn.qf.taobao.pojo.entity.*;
import cn.qf.taobao.service.CommodityService;

import java.util.ArrayList;
import java.util.List;

public class CommodityServiceImpl  implements CommodityService {

    private  CommodityDao commodityDao = new CommodityDaoImpl();
    @Override
    public Commodity commodityClassifyService(String classifyName) {

        Commodity commodity = commodityDao.selectClassifyCommodity(classifyName);
        if (commodity==null){
            throw new RuntimeException("无此分类商品");
        }
        return commodity;
    }

    @Override
    public List<Classify> classifyService() {

        List<Classify> classifies = commodityDao.selectClassify();
        if (classifies==null){
            throw new RuntimeException("无分类");
        }
        return classifies;
    }

    @Override
    public List<Commodity> randomCommodityService() {

        List<Commodity> commodities = commodityDao.selectRandomCommodity();

        if (commodities==null){
            throw new RuntimeException("随机商品查询失败");
        }

        return commodities;
    }

    @Override
    public Commodity oneCommodityService(Long id) {

        Commodity commodity = commodityDao.oneCommodity(id);
        if (commodity==null){
            throw  new RuntimeException("查询单个商品失败");
        }
        return commodity;
    }

    @Override
    public boolean addCommodityService(Long commodityId, Long userId) {

        Favorite favorite = commodityDao.selectFavoriteCommodity(commodityId, userId);
        if (favorite==null){
            int i = commodityDao.addCommodity(commodityId, userId);
            if (i==0){
                throw new RuntimeException("添加收藏夹商品失败");
            }
            return true;
        }
        throw new RuntimeException("商品已收藏");


    }

    @Override
    public List<Commodity> favoriteCommodityService(Long userId) {

        List<Commodity> commodities = commodityDao.favoriteCommodity(userId);

        if (commodities==null){
            throw new RuntimeException("没有收藏商品哦！");
        }
        return commodities;
    }

    @Override
    public boolean deleteFavoriteCommodityService(Long commodityId, Long userId) {

        int i = commodityDao.deleteFavoriteCommodity(commodityId, userId);
        if (i==0){
            throw new RuntimeException("删除收藏商品失败");
        }

        return true;
    }

    @Override
    public boolean addFootprint(Long commodityId, Long userId) {

        Favorite favorite = commodityDao.existFootprint(commodityId, userId);
        if (favorite!=null){
            int i = commodityDao.deleteFootprint(commodityId, userId);
            if (i==0){
                throw new RuntimeException("删除足迹失败");
            }
            int i1 = commodityDao.addFootprint(commodityId, userId);
            if (i1==0){
                throw new RuntimeException("足迹记录失败");
            }
            return true;
        }

        int i = commodityDao.addFootprint(commodityId, userId);
        if (i==0){
            throw new RuntimeException("足迹记录失败");
        }
        return true;
    }

    @Override
    public List<Commodity> selectFootprint(Long userId) {

        List<Commodity> commodities = commodityDao.selectFootprint(userId);
        if (commodities==null){
            throw new RuntimeException("查询足迹失败");
        }

        return commodities;
    }

    @Override
    public List<Commodity> deleteFootprintService(Long commodityId, Long userId) {

        int i = commodityDao.deleteFootprint(commodityId, userId);
        if (i==0){
            throw new RuntimeException("删除足迹失败");
        }

        return selectFootprint(userId);
    }

    @Override
    public boolean addShopCatService(Long commodityId, Long userId,Long num) {

        Commodity commodity = commodityDao.oneCommodity(commodityId);
        Double commodityPrice = commodity.getCommodityPrice();
        Double totalPrices = commodityPrice*num;

        Favorite favorite = commodityDao.existShopCat(commodityId, userId);
        if (favorite==null){
            int i = commodityDao.addShopCat(commodityId, userId,num,totalPrices);
            if (i==0){
                throw new RuntimeException("添加购物车失败！");
            }
            return true;
        }
        throw new RuntimeException("商品已在购物车哦");


    }

    @Override
    public List<Commodity> alterShopCatService(Long commodityId, Long userId, Long num) {

        int i = commodityDao.deleteShopCat(commodityId, userId);
        if (i==0){
            throw new RuntimeException("删除购物车失败！");
        }
        Commodity commodity = commodityDao.oneCommodity(commodityId);
        Double commodityPrice = commodity.getCommodityPrice();
        Double totalPrices = commodityPrice*num;

        int i1 = commodityDao.addShopCat(commodityId, userId, num, totalPrices);
        if (i1==0){
            throw new RuntimeException("修改添加购物车失败！");
        }
        List<Commodity> commodities = selectShopCatService(userId);
        if (commodities==null){
            throw new RuntimeException("购物车里没有商品哦");
        }
        return commodities;

    }

    @Override
    public List<Commodity> selectShopCatService(Long userId) {

        List<Commodity> commodities = commodityDao.selectShopCat(userId);
        if (commodities==null){
            throw new RuntimeException("购物车里没有商品哦");
        }
        return commodities;
    }

    @Override
    public List<Commodity> deleteShopCat(Long commodityId, Long userId) {


        int i = commodityDao.deleteShopCat(commodityId, userId);
        if (i==0){
            throw new RuntimeException("删除购物车失败");
        }
        List<Commodity> commodities = commodityDao.selectShopCat(userId);
        if (commodities==null){
            throw new RuntimeException("查询购物车失败");
        }
        return commodities;
    }

    @Override
    public List<Commodity> selectClassifyCommodityIdService(Long classifyId,Long pages) {

        List<Commodity> commodities = commodityDao.selectClassifyCommodityId(classifyId,pages);
        if (commodities==null){
            throw new RuntimeException("查询分类商品失败!");
        }

        return commodities;
    }

    @Override
    public List<Commodity> salesClassifyCommodityService(Long classifyId, Long pages) {

        List<Commodity> commodities = commodityDao.salesClassifyCommodity(classifyId, pages);
        if (commodities==null){
            throw new RuntimeException("销量查询分类商品失败!");
        }
        return commodities;
    }

    @Override
    public List<Commodity> priceBigClassifyCommodityService(Long classifyId, Long pages) {

        List<Commodity> commodities = commodityDao.priceBigClassifyCommodity(classifyId, pages);
        if (commodities==null){
            throw new RuntimeException("价格降序查询分类商品失败!");

        }        return commodities;
    }

    @Override
    public List<Commodity> priceSmallClassifyCommodityService(Long classifyId, Long pages) {

        List<Commodity> commodities = commodityDao.priceSmallClassifyCommodity(classifyId, pages);
        if (commodities==null){
            throw new RuntimeException("价格升序查询分类商品失败!");
        }
        return commodities;
    }

    @Override
    public Pages selectClassifyNumService(Long classifyId) {

        Long num = (Long)commodityDao.selectClassifyNum(classifyId);

        if (num==0){

        throw new RuntimeException("没有此分类商品啦");

        }
        Pages pages = new Pages();
        pages.setNum(num);

        ArrayList<Integer> integers = new ArrayList<>();
        if (num%12==0){
            num=num/12;
        }else {
            num=num/12+1;
        }
        for (int i=1;i<=num;i++){
            integers.add(i);
        }
        pages.setPagesNum(integers);
        return pages;
    }


}
