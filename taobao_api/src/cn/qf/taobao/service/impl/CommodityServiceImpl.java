package cn.qf.taobao.service.impl;

import cn.qf.taobao.dao.CommodityDao;
import cn.qf.taobao.dao.impl.CommodityDaoImpl;
import cn.qf.taobao.pojo.entity.Classify;
import cn.qf.taobao.pojo.entity.Commodity;
import cn.qf.taobao.pojo.entity.Favorite;
import cn.qf.taobao.service.CommodityService;

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
}
