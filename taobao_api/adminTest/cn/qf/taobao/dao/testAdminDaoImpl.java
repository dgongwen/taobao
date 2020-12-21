package cn.qf.taobao.dao;

import cn.qf.taobao.dao.impl.AdminDaoImpl;
import org.junit.Test;

public class testAdminDaoImpl {
    private AdminDao adminDao = new AdminDaoImpl();
   /*@Test
    public void testSelectAdmin(){
        AdminLoginQO admin = adminDao.selectAdmin("admin", "123456");
        System.out.println(admin);
        if(admin.equals(null)){
            throw new RuntimeException("testSelectAdmin 测试通过");
        }else {
            throw new RuntimeException("testSelectAdmin 测试不通过");
        }

    }
    @Test
    public void testSelectAdminCommodityByName(){
        AdminCommodityQO cloth = adminDao.selectAdminCommodityByName("衣服");
        System.out.println(cloth);
        if(!cloth.equals(null)){
            throw new RuntimeException("testSelectAdmin 测试通过");
        }else {
            throw new RuntimeException("testSelectAdmin 测试不通过");
        }
    }
    @Test
    public void testSelectAdminCommodityByNameState(){
        AdminCommodityQO cloth = adminDao.selectAdminCommodityByNameStatus("茶杯", 1);
        System.out.println(cloth);
        if(!cloth.equals(null)){
            throw new RuntimeException("testSelectAdmin 测试通过");
        }else {
            throw new RuntimeException("testSelectAdmin 测试不通过");
        }
    }
    @Test
    public void testInsertAdminCommodity(){
        AdminCommodityQO a = new AdminCommodityQO();
        a.setCommodityName("呵呵");
        a.setCommodityPrice(56.0);
        a.setCommodityImgUrl("4546654");
        a.setClassificationId(2);
        int i = adminDao.insertAdminCommodity(a);
        if(i==1){
            System.out.println("测试通过");
        }else{
            System.out.println("测试不通过");
        }
    }
    @Test
    public void testUpdateAdminCommodityById(){
        AdminCommodityQO a = new AdminCommodityQO();
        a.setCommodityName("喔喔");
        a.setCommodityPrice(88.0);
        a.setCommodityImgUrl("辅导费是");
        a.setClassificationId(1);
        a.setId(148);
        int i = adminDao.updateAdminCommodityById(a);
        System.out.println(i);
        if(i==1){
            System.out.println("测试通过");
        }else{
            System.out.println("测试不通过");
        }
    }*/
    @Test
    public void testDelAdminCommodity(){
        int i = adminDao.delAdminCommodityById(16);
        if(i==1){
            System.out.println("测试通过");
        }else{
            System.out.println("测试不通过");
        }
    }

}
