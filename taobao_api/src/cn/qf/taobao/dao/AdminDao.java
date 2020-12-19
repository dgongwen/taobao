package cn.qf.taobao.dao;

import cn.qf.taobao.pojo.qo.AdminCommodityQO;
import cn.qf.taobao.pojo.qo.AdminLoginQO;

import java.util.List;

/**
 * 管理员操作类DAO接口
 */
public interface AdminDao {
    //根据管理员名和密码查询管理员
    AdminLoginQO selectAdmin(String adminUserName,String adminUserPassword);

    //根据商品ID查询商品
    AdminCommodityQO selectAdminCommodityByID(int id);

    //根据商品名称查询商品
    List<AdminCommodityQO> selectAdminCommodityByName(String commodityName);

    //根据商品名称和商品是否上架查询商品
    AdminCommodityQO selectAdminCommodityByNameStatus(String commodityName,String commodityState);

    //展示所有商品（包含上下架）
    List<AdminCommodityQO> selectAdminCommodity();

    //根据商品是否上下架展示所有商品
    List<AdminCommodityQO> selectAdminCommodityByState(String commodityState);

    //根据商品ID修改商品信息
    int updateAdminCommodityById(AdminCommodityQO adminCommodityQO);

    //增加商品
    int insertAdminCommodity(String commodityNum, String commodityName, Double commodityPrice, String commodityImgUrl, int classificationId,String commodityState);

    //根据商品ID删除商品
    int delAdminCommodityById(int id);

    //查找所有伪删除的商品
    List<AdminCommodityQO> selectDelCommodity();

    //取消伪删除的商品
    int updateCancelDelCommodity(int id);

    //根据ID修改商品上下架
    int updateUpSoldCommodity(String commodityState,int id);

    //随机展示12条数据
    List<AdminCommodityQO> randomCommodity();

    //删除数据
    int trueDelAdminCommodityById(int id);
}
