import cn.qf.taobao.dao.CommodityDao;
import cn.qf.taobao.dao.impl.CommodityDaoImpl;
import cn.qf.taobao.pojo.entity.Favorite;
import cn.qf.taobao.pojo.entity.Pages;

import java.util.Random;

public class test {
    public static void main(String[] args) {
        CommodityDaoImpl commodityDao = new CommodityDaoImpl();
        //Favorite favorite = commodityDao.selectFavoriteCommodity(Long.valueOf(1), Long.valueOf(30));
       // System.out.println(favorite);

        Object o = commodityDao.selectClassifyNum(1L);
        System.out.println(o);


    }
}
