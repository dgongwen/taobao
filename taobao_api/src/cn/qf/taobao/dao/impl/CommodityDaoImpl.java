package cn.qf.taobao.dao.impl;

import cn.qf.taobao.dao.CommodityDao;
import cn.qf.taobao.pojo.entity.Classify;
import cn.qf.taobao.pojo.entity.Commodity;
import cn.qf.taobao.util.DruidUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class CommodityDaoImpl implements CommodityDao {
    //创建DBUtil工具
    private QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
    private  Random random = new Random();
    @Override
    public Commodity selectClassifyCommodity(String classifyName) {
        String sql="SELECT tc.* FROM t_commodity tc LEFT JOIN t_commodity_classification tcc ON tc.classification_id=tcc.id WHERE tcc.classification_name=?";
        //开启下划线->驼峰转换所用
        BeanProcessor bean = new GenerousBeanProcessor();
        RowProcessor processor = new BasicRowProcessor(bean);
        BeanHandler<Commodity> commodityBean = new BeanHandler<>(Commodity.class,processor);
        try {
           return queryRunner.query(sql,commodityBean,classifyName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Classify> selectClassify() {
        String sql="SELECT * FROM t_commodity_classification";

        //开启下划线->驼峰转换所用
        BeanProcessor bean = new GenerousBeanProcessor();
        RowProcessor processor = new BasicRowProcessor(bean);
        BeanListHandler<Classify> classify = new BeanListHandler<>(Classify.class,processor);
        try {
            return  queryRunner.query(sql, classify);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Commodity> selectRandomCommodity() {
        int i = random.nextInt(95);

        String sql="SELECT * FROM t_commodity LIMIT ?,15";

        //开启下划线->驼峰转换所用
        BeanProcessor bean = new GenerousBeanProcessor();
        RowProcessor processor = new BasicRowProcessor(bean);
        BeanListHandler<Commodity> commodityList = new BeanListHandler<>(Commodity.class,processor);

        try {


            return queryRunner.query(sql, commodityList,i);



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
