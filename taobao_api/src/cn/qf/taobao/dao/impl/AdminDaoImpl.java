package cn.qf.taobao.dao.impl;

import cn.qf.taobao.dao.AdminDao;
import cn.qf.taobao.pojo.qo.AdminCommodityQO;
import cn.qf.taobao.pojo.qo.AdminLoginQO;
import cn.qf.taobao.util.DBUtil;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 管理员操作类DAO层的实现类
 */
public class AdminDaoImpl implements AdminDao {
     private  QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSource());

    //根据管理员用户名和密码查询管理员
    @Override
    public AdminLoginQO selectAdmin(String adminUserName, String adminUserPassword) {
        String selectAdminSql = "SELECT * FROM t_admin_user WHERE  admin_user_name=? AND admin_user_password=?";
        try {
            GenerousBeanProcessor beanProcessor = new GenerousBeanProcessor();
            BasicRowProcessor row = new BasicRowProcessor(beanProcessor);
            return queryRunner.query(selectAdminSql, new BeanHandler<AdminLoginQO>(AdminLoginQO.class,row), adminUserName,adminUserPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    //根据商品ID查询商品
    @Override
    public AdminCommodityQO selectAdminCommodityByID(int id) {
        String SelectAdminCommodityByIdSql="SELECT a.classification_id,a.commodity_name,a.commodity_Price,a.commodity_img_url,a.commodity_num,a.commodity_sales,b.classification_name,a.commodity_state FROM t_commodity a,t_commodity_classification b WHERE  a.commodity_status = 1 AND a.classification_id=b.classification_id AND a.commodity_state='上架' AND a.id=?";
        try {
            GenerousBeanProcessor beanProcessor = new GenerousBeanProcessor();
            BasicRowProcessor row = new BasicRowProcessor(beanProcessor);
            return queryRunner.query(SelectAdminCommodityByIdSql,new BeanHandler<AdminCommodityQO>(AdminCommodityQO.class,row),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //根据商品名称查询商品（模糊查询）
    @Override
    public AdminCommodityQO selectAdminCommodityByName(String commodityName) {
        String SelectAdminCommodityByName="SELECT a.classification_id,a.commodity_name,a.commodity_Price,a.commodity_img_url,a.commodity_num,a.commodity_sales,b.classification_name,a.commodity_state FROM t_commodity a,t_commodity_classification b WHERE  a.commodity_status = 1 AND a.classification_id=b.classification_id AND a.commodity_state='上架'  AND a.commodity_name LIKE ? ";
        String commodityNames="%"+commodityName+"%";
        try {
            GenerousBeanProcessor beanProcessor = new GenerousBeanProcessor();
            BasicRowProcessor row = new BasicRowProcessor(beanProcessor);
            return queryRunner.query(SelectAdminCommodityByName,new BeanHandler<AdminCommodityQO>(AdminCommodityQO.class,row),commodityNames);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //根据商品是否上架按商品名称查询（模糊查询）
    @Override
    public AdminCommodityQO selectAdminCommodityByNameStatus(String commodityName, String commodityState) {
        String SelectAdminCommodityByNameStatus="SELECT a.classification_id,a.commodity_name,a.commodity_Price,a.commodity_img_url,a.commodity_num,a.commodity_sales,b.classification_name,a.commodity_state FROM t_commodity a,t_commodity_classification b WHERE  a.commodity_status = 1 AND a.classification_id=b.classification_id AND a.commodity_state=?  AND a.commodity_name LIKE ?";
        String commodityNames="%"+commodityName+"%";
        try {
            GenerousBeanProcessor beanProcessor = new GenerousBeanProcessor();
            BasicRowProcessor row = new BasicRowProcessor(beanProcessor);
            return queryRunner.query(SelectAdminCommodityByNameStatus,new BeanHandler<AdminCommodityQO>(AdminCommodityQO.class,row),commodityState,commodityNames);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //展示所有商品，包含上架以及未上架
    @Override
    public List<AdminCommodityQO> selectAdminCommodity() {
        String SelectAdminCommodity="SELECT a.classification_id,a.commodity_name,a.commodity_Price,a.commodity_img_url,a.commodity_num,a.commodity_sales,b.classification_name,a.commodity_state ,a.id FROM t_commodity a,t_commodity_classification b WHERE  a.commodity_status = 1 AND a.classification_id=b.classification_id  ";
        try {
            GenerousBeanProcessor beanProcessor = new GenerousBeanProcessor();
            BasicRowProcessor row = new BasicRowProcessor(beanProcessor);
            return queryRunner.query(SelectAdminCommodity,new BeanListHandler<AdminCommodityQO>(AdminCommodityQO.class,row));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //根据是否上架展示所有商品，1代表上架，0代表下架
    @Override
    public List<AdminCommodityQO> selectAdminCommodityByState(String commodityState) {
        String SelectAdminCommodityByState="SELECT a.id,a.classification_id,a.commodity_name,a.commodity_Price,a.commodity_img_url,a.commodity_num,a.commodity_sales,b.classification_name,a.commodity_state FROM t_commodity a,t_commodity_classification b WHERE  a.commodity_status = 1 AND a.classification_id=b.classification_id AND a.commodity_state=?  ";
        try {
            GenerousBeanProcessor beanProcessor = new GenerousBeanProcessor();
            BasicRowProcessor row = new BasicRowProcessor(beanProcessor);
            return queryRunner.query(SelectAdminCommodityByState,new BeanListHandler<AdminCommodityQO>(AdminCommodityQO.class,row),commodityState);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //根据ID修改商品
    @Override
    public int updateAdminCommodityById(int id, String commodityNum, String commodityName, Double commodityPrice, String commodityImgUrl, int classificationId,String commodityState) {
        String updateAdminCommodityByIdSql = "UPDATE t_commodity SET commodity_name=?,commodity_Price=?,commodity_img_url=?,commodity_num=?,classification_id=?,commodity_state=? where commodity_state='下架' AND id=?";
        Object[] params={commodityName,commodityPrice,commodityImgUrl,classificationId,commodityState,id};
        try {
            return queryRunner.update(updateAdminCommodityByIdSql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //添加商品
    @Override
    public int insertAdminCommodity( String commodityNum, String commodityName, Double commodityPrice, String commodityImgUrl, int classificationId,String commodityState) {
        String insertAdminCommoditySql = "INSERT INTO t_commodity (commodity_name,commodity_Price,commodity_img_url,classification_id,commodity_num,commodity_state) values(?,?,?,?,?,?)";
        Object[] params = {commodityName,commodityPrice,commodityImgUrl,classificationId,commodityNum,commodityState};
        try {
            return queryRunner.update(insertAdminCommoditySql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //根据商品ID删除商品
    @Override
    public int delAdminCommodityById(int id) {
        String delAdminCommodityByIdSql="UPDATE t_commodity SET commodity_status=0 WHERE commodity_state='下架' AND id=?";
        Object[] params = {id};
        try {
            return queryRunner.update(delAdminCommodityByIdSql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    //查询所有已删除商品
    @Override
    public List<AdminCommodityQO> selectDelCommodity() {
        String selectDelCommoditySql = "SELECT a.id,a.classification_id,a.commodity_name,a.commodity_Price,a.commodity_img_url,a.commodity_num,a.commodity_sales,b.classification_name FROM t_commodity a,t_commodity_classification b WHERE  a.commodity_status = 0 AND a.classification_id=b.classification_id   ";
        try {
            GenerousBeanProcessor beanProcessor = new GenerousBeanProcessor();
            BasicRowProcessor row = new BasicRowProcessor(beanProcessor);
            return queryRunner.query(selectDelCommoditySql, new BeanListHandler<AdminCommodityQO>(AdminCommodityQO.class,row));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //取消商品删除
    @Override
    public int updateCancelDelCommodity(int id) {
        String updateCancelDelCommodity = "UPDATE t_commodity SET commodity_status=1 WHERE id=?";
        Object[] params = {id};
        try {
            return queryRunner.update(updateCancelDelCommodity,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
//根据商品ID修改商品上下架
    @Override
    public int updateUpSoldCommodity(String commodityState,int id) {
        String updateCancelDelCommodity = "UPDATE t_commodity SET commodity_state=? WHERE id=?";
        Object[] params = {commodityState,id};
        try {
            return queryRunner.update(updateCancelDelCommodity,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
