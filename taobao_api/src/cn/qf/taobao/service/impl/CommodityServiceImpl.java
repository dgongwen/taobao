package cn.qf.taobao.service.impl;

import cn.qf.taobao.dao.CommodityDao;
import cn.qf.taobao.dao.impl.CommodityDaoImpl;
import cn.qf.taobao.pojo.entity.Classify;
import cn.qf.taobao.pojo.entity.Commodity;
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
}
