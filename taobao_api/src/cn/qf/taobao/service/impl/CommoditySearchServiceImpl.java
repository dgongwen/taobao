package cn.qf.taobao.service.impl;

import cn.qf.taobao.dao.CommoditySearchDao;
import cn.qf.taobao.dao.impl.CommoditySearchDaoImpl;
import cn.qf.taobao.pojo.entity.Commodity;
import cn.qf.taobao.pojo.entity.Page;
import cn.qf.taobao.service.CommoditySearchService;

import java.util.List;

/**
 * @author dian
 * @date 2020/12/15
 */
public class CommoditySearchServiceImpl implements CommoditySearchService {
    CommoditySearchDao commoditySearch = new CommoditySearchDaoImpl();
    private Page<Commodity> page = new Page<>();

    public Page<Commodity> getPage() {
        page.setPageSize(12);
        return page;
    }

    @Override
    public List<Commodity> searchByPriceDesc(int currentPage) {
        List<Commodity> searchByPriceDesc = commoditySearch.searchByPriceDesc(currentPage,page.getPageSize());
        if(null != searchByPriceDesc){
            return searchByPriceDesc;
        }
        return null;
    }

    @Override
    public List<Commodity> searchByPriceAsc(int currentPage) {
        List<Commodity> searchByPriceAsc = commoditySearch.searchByPriceAsc(currentPage,page.getPageSize());
        if(null != searchByPriceAsc){
            return searchByPriceAsc;
        }
        return null;
    }

    @Override
    public List<Commodity> searchBySaleCount(int currentPage) {
        List<Commodity> commodityList = commoditySearch.searchBySaleCount(currentPage,page.getPageSize());
        if(null != commodityList){
            return commodityList;
        }
        return null;
    }

    @Override
    public List<Commodity> searchByKeyWord(String searchContent,int currentPage) {
        List<Commodity> commodities = commoditySearch.searchByKeyWord(searchContent,currentPage,page.getPageSize());
        if(null != commodities){
            return commodities;
        }
        return null;
    }

}
