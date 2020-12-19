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
    Page<Commodity> page = new Page<>();

    /*@Override
    public List<Commodity> searchByPriceDesc(int page,int pageSize) {
        List<Commodity> searchByPriceDesc = commoditySearch.searchByPriceDesc(page,pageSize);
        if(null != searchByPriceDesc){
            return searchByPriceDesc;
        }
        return null;
    }*/

    /*@Override
    public List<Commodity> searchByPriceAsc() {
        List<Commodity> searchByPriceAsc = commoditySearch.searchByPriceAsc();
        if(null != searchByPriceAsc){
            return searchByPriceAsc;
        }
        return null;
    }*/

    /*@Override
    public List<Commodity> searchBySaleCount() {
        List<Commodity> commodityList = commoditySearch.searchBySaleCount();
        if(null != commodityList){
            return commodityList;
        }
        return null;
    }*/

    /*@Override
    public List<Commodity> searchByKeyWord(String searchContent) {
        List<Commodity> commodities = commoditySearch.searchByKeyWord(searchContent);
        if(null != commodities){
            return commodities;
        }
        return null;
    }*/

    @Override
    public Page<Commodity> searchByKeyWord(String searchContent, int currentPage) {
        int pageSize = 12;
        currentPage = (currentPage-1)*pageSize;
        List<Commodity> searchByKeyWord = commoditySearch.searchByKeyWord(searchContent, currentPage, pageSize);
        int searchCountByWord = commoditySearch.searchByWordCount(searchContent).intValue();
        return getCommodityPage(currentPage,pageSize,searchByKeyWord,searchCountByWord);
    }

    @Override
    public Page<Commodity> searchByPriceDesc(int currentPage) {
        int pageSize = 12;
        currentPage = (currentPage-1)*pageSize;
        List<Commodity> searchByPriceDesc = commoditySearch.searchByPriceDesc(currentPage,pageSize);
        int searchCount = commoditySearch.searchCount().intValue();
        return getCommodityPage(currentPage, pageSize, searchByPriceDesc, searchCount);
    }

    @Override
    public Page<Commodity> searchByPriceAsc(int currentPage) {
        int pageSize = 12;
        currentPage = (currentPage-1)*pageSize;
        List<Commodity> searchByPriceAsc = commoditySearch.searchByPriceAsc(currentPage, pageSize);
        int searchCount = commoditySearch.searchCount().intValue();
        return getCommodityPage(currentPage,pageSize,searchByPriceAsc,searchCount);
    }

    @Override
    public Page<Commodity> searchBySaleCount(int currentPage) {
        int pageSize = 12;
        currentPage = (currentPage-1)*pageSize;
        List<Commodity> searchBySaleCount = commoditySearch.searchBySaleCount(currentPage, pageSize);
        int searchCount = commoditySearch.searchCount().intValue();
        return getCommodityPage(currentPage,pageSize,searchBySaleCount,searchCount);
    }

    private Page<Commodity> getCommodityPage(int currentPage, int pageSize, List<Commodity> searchByPriceDesc, int searchCount) {
        page.setCurrentPage(currentPage);
        page.setPageSize(pageSize);
        page.setTotalCount(searchCount);
        page.setList(searchByPriceDesc);
        page.setTotalPage((int) Math.ceil(page.getTotalCount()*1.0/pageSize));
        return page;
    }

}
