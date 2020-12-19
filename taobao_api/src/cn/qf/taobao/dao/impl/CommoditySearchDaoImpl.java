package cn.qf.taobao.dao.impl;

import cn.qf.taobao.dao.CommoditySearchDao;
import cn.qf.taobao.pojo.entity.Commodity;
import cn.qf.taobao.util.DruidUtil;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author dian
 * @date 2020/12/15
 */
public class CommoditySearchDaoImpl implements CommoditySearchDao {
    //连接池连接
    private QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
    //开启驼峰法
    private RowProcessor processor = new BasicRowProcessor(new GenerousBeanProcessor());

    @Override
    public Long searchCount() {
        //sql语句
        String sql = "SELECT COUNT(1) FROM t_commodity";
        //执行sql语句
        try {
            return queryRunner.query(sql,new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public List<Commodity> searchByPriceDesc(int page, int pageSize) {
        //sql语句
        String sql = "SELECT commodity_name,commodity_Price,commodity_img_url,commodity_sales FROM t_commodity WHERE \n" +
                "commodity_name IS NOT NULL AND \n" +
                "commodity_Price IS NOT NULL AND \n" +
                "commodity_img_url IS NOT NULL  ORDER BY commodity_Price DESC LIMIT ?,?";
        //执行sql语句
        return getCommodities(page, pageSize, sql);
    }

    @Override
    public List<Commodity> searchByPriceAsc(int page,int pageSize) {
        //sql语句
        String sql = "SELECT commodity_name,commodity_Price,commodity_img_url,commodity_sales FROM t_commodity WHERE \n" +
                "commodity_name IS NOT NULL AND \n" +
                "commodity_Price IS NOT NULL AND \n" +
                "commodity_img_url IS NOT NULL  ORDER BY commodity_Price ASC LIMIT ?,?";
        //执行sql语句
        return getCommodities(page, pageSize, sql);
    }

    @Override
    public List<Commodity> searchBySaleCount(int page,int pageSize) {
        //sql语句
        String sql = "SELECT commodity_name,commodity_Price,commodity_img_url,commodity_sales FROM t_commodity WHERE \n" +
                "commodity_name IS NOT NULL AND \n" +
                "commodity_Price IS NOT NULL AND \n" +
                "commodity_img_url IS NOT NULL  ORDER BY commodity_sales Desc LIMIT ?,?";
        //执行sql语句
        return getCommodities(page, pageSize, sql);
    }

    @Override
    public List<Commodity> searchByKeyWord(String searchContent,int page,int pageSize) {
        //sql语句
        String sql = "SELECT commodity_name,commodity_Price,commodity_img_url,commodity_sales FROM t_commodity WHERE commodity_name IS NOT NULL AND \n" +
                "commodity_Price IS NOT NULL AND \n" +
                "commodity_img_url IS NOT NULL AND  commodity_name LIKE ? LIMIT ?,?";
        //执行sql语句
        try {
            return queryRunner.query(sql,new BeanListHandler<Commodity>(Commodity.class,processor),"%"+searchContent+"%",page,pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("查询失败",throwables);
        }
    }

    @Override
    public Long searchByWordCount(String searchContent) {
        //sql语句
        String sql = "SELECT COUNT(1) FROM t_commodity WHERE commodity_name LIKE ? ";
        //执行sql语句
        try {
            return queryRunner.query(sql,new ScalarHandler<>(),"%"+searchContent+"%");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    private List<Commodity> getCommodities(int page, int pageSize, String sql) {
        try {
            return queryRunner.query(sql, new BeanListHandler<>(Commodity.class, processor), page, pageSize);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("排序失败", throwables);
        }
    }
}
