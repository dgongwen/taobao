package cn.qf.taobao.dao.impl;

import cn.qf.taobao.dao.CommoditySearchDao;
import cn.qf.taobao.pojo.entity.Commodity;
import cn.qf.taobao.pojo.entity.SearchContent;
import cn.qf.taobao.util.DruidUtil;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author dian
 * @date 2020/12/15
 */
public class CommoditySearchDaoImpl implements CommoditySearchDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
    //开启驼峰法
    private RowProcessor processor = new BasicRowProcessor(new GenerousBeanProcessor());
    @Override
    public List<Commodity> searchByPriceDesc() {
        //sql语句
        String sql = "SELECT commodity_name,commodity_Price,commodity_img_url FROM t_commodity ORDER BY commodity_Price DESC";
        //执行sql语句
        try {
            return queryRunner.query(sql,new BeanListHandler<Commodity>(Commodity.class,processor));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("排序失败",throwables);
        }
    }

    @Override
    public List<Commodity> searchByPriceAsc() {
        //sql语句
        String sql = "SELECT commodity_name,commodity_Price,commodity_img_url FROM t_commodity ORDER BY commodity_Price ASC";
        //执行sql语句
        try {
            return queryRunner.query(sql,new BeanListHandler<Commodity>(Commodity.class,processor));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("排序失败",throwables);
        }
    }

    @Override
    public List<Commodity> searchByKeyWord(SearchContent searchContent) {
        String searchContent1 = searchContent.getSearchContent();
        //sql语句
        String sql = "SELECT commodity_name,commodity_Price,commodity_img_url FROM t_commodity WHERE commodity_name LIKE ?";
        //执行sql语句
        try {
            return queryRunner.query(sql,new BeanListHandler<Commodity>(Commodity.class,processor),"%"+searchContent1+"%");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("查询失败",throwables);
        }
    }
}
