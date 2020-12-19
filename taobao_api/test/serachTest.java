

import cn.qf.taobao.dao.impl.CommoditySearchDaoImpl;
import cn.qf.taobao.pojo.entity.Commodity;
import cn.qf.taobao.pojo.entity.Page;
import cn.qf.taobao.service.impl.CommoditySearchServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author dian
 * @date 2020/12/17
 */
public class serachTest {
    public static void main(String[] args) {
        CommoditySearchDaoImpl commoditySearchDao = new CommoditySearchDaoImpl();


    }
    @Test
    public void test1(){
        CommoditySearchDaoImpl commoditySearchDao = new CommoditySearchDaoImpl();
        List<Commodity> list = commoditySearchDao.searchByKeyWord("学生", 3, 12);
        System.out.println(list);

    }

    @Test
    public void test2(){
        CommoditySearchServiceImpl commoditySearchService = new CommoditySearchServiceImpl();
        Page<Commodity> commodityPage = commoditySearchService.searchByKeyWord("学生", 1);
        System.out.println(commodityPage);
    }
    @Test
    public void test3(){
        CommoditySearchDaoImpl commoditySearchDao = new CommoditySearchDaoImpl();
        Long aLong = commoditySearchDao.searchCount();
        System.out.println(aLong);
    }
}
