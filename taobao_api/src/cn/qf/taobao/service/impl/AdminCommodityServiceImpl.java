package cn.qf.taobao.service.impl;

import cn.qf.taobao.dao.AdminDao;
import cn.qf.taobao.dao.impl.AdminDaoImpl;
import cn.qf.taobao.pojo.qo.AdminCommodityQO;
import cn.qf.taobao.pojo.qo.AdminLoginQO;
import cn.qf.taobao.service.AdminCommodityService;

import java.util.List;

public class AdminCommodityServiceImpl implements AdminCommodityService {
    private AdminDao adminDao = new AdminDaoImpl();


    @Override
    public int selectAdminService(String adminUserName, String adminUserPassword) {
        AdminLoginQO adminLoginQO = adminDao.selectAdmin(adminUserName, adminUserPassword);
        if (adminLoginQO!=null){
            return 1;
        }
        return 0;

    }

    @Override
    public AdminCommodityQO selectAdminCommodityByIDService(int id) {
        AdminCommodityQO adminId = adminDao.selectAdminCommodityByID(id);
        System.out.println("selectAdminByIdService"+adminId);
        return adminId;
    }

    @Override
    public AdminCommodityQO selectAdminCommodityByNameService(String commodityName) {
        AdminCommodityQO adminByName = adminDao.selectAdminCommodityByName(commodityName);
        System.out.println("selectAdminByName"+adminByName);
        return adminByName;
    }

    @Override
    public AdminCommodityQO selectAdminCommodityByNameStatusService(String commodityName, String commodityState) {
        AdminCommodityQO ad = adminDao.selectAdminCommodityByNameStatus(commodityName, commodityState);
        System.out.println("selectAdminCommodityByNameStatusService"+ad);
        return ad;
    }

    @Override
    public List<AdminCommodityQO> selectAdminCommodityService() {
        List<AdminCommodityQO> ad = adminDao.selectAdminCommodity();
        System.out.println("selectAdminCommodity"+ad);
        return ad;
    }

    @Override
    public List<AdminCommodityQO> selectAdminCommodityByStateService(String commodityState) {
        List<AdminCommodityQO> ad = adminDao.selectAdminCommodityByState(commodityState);
        System.out.println("selectAdminCommodityByStateService"+ad);
        return ad;
    }

    @Override
    public int updateAdminCommodityById(int id, String commodityNum, String commodityName, Double commodityPrice, String commodityImgUrl, int classificationId,String commodityState) {
        int i = adminDao.updateAdminCommodityById(id,commodityNum,commodityName,commodityPrice,commodityImgUrl,classificationId,commodityState);
        return i;
    }

    @Override
    public int insertAdminCommodity(String commodityNum, String commodityName, Double commodityPrice, String commodityImgUrl, int classificationId,String commodityState) {
        return adminDao.insertAdminCommodity(commodityNum,commodityName,commodityPrice,commodityImgUrl,classificationId,commodityState);
    }

    @Override
    public int delAdminCommodityById(int id) {
        return adminDao.delAdminCommodityById(id);
    }

    @Override
    public List<AdminCommodityQO> selectDelCommodity() {
        return adminDao.selectDelCommodity();
    }

    @Override
    public int updateCancelDelCommodity(int id) {
        return adminDao.updateCancelDelCommodity(id);
    }

    @Override
    public int updateUpSoldCommodity(String commodityState, int id) {
        return adminDao.updateUpSoldCommodity(commodityState,id);
    }
}
