package cn.qf.taobao.dao.impl;
import cn.qf.taobao.dao.IndentDao;
import cn.qf.taobao.pojo.entity.Commodity;
import cn.qf.taobao.pojo.entity.Indent;
import cn.qf.taobao.util.DruidUtil;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.SQLException;
import java.util.List;

public class IndentDaoImpl implements IndentDao {

    //使用Dbutils
    private QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());


    //创建订单
    @Override
    public int createIndent(Indent indent) {
        Object[] params={indent.getIndentSn(),indent.getCreateTime(),indent.getCommodityName(),indent.getCommodityImgUrl(),indent.getCommodityNumber(),indent.getTotalAmount(),indent.getReceiverName(),indent.getReceiverPhone(),indent.getReceiverAddress()};
        try {
            return queryRunner.update("insert into indent(indent_sn,create_time,commodity_name,commodity_img_url,commodity_number,total_amount,receiver_name,receiver_phone,receiver_address) value (?,?,?,?,?,?,?,?,?)"
                    ,params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    //查询商品单价,数量
    @Override
    public Commodity selectPrice(Long productId) {
        try {
            //驼峰命名法
            GenerousBeanProcessor Processor = new GenerousBeanProcessor();
            BasicRowProcessor row = new BasicRowProcessor(Processor);
            //把查询到的记录封装成 指定对象
            return queryRunner.query("select commodity_price,commodity_num,commodity_img_url from t_commodity where id = ?"
                    , new BeanHandler<Commodity>(Commodity.class,row), productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    //查询订单
    @Override
    public List<Indent> selectIndent(String snow) {
        try {
            //驼峰命名法
            GenerousBeanProcessor Processor = new GenerousBeanProcessor();
            BasicRowProcessor row = new BasicRowProcessor(Processor);
            //把查询到的记录封装成 指定对象
            return queryRunner.query("select * from indent where indent_sn = ?"
                    ,new BeanListHandler<Indent>(Indent.class,row),snow);

        }catch (Exception e){
         e.printStackTrace();
        }

        return null;
    }


    //取消订单
    @Override
    public int updateIndent(long indentIds) {
        try {
            return queryRunner.update("update indent set status = 1 where indent_id = ?"
                    ,indentIds);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    //展示订单
    @Override
    public List<Indent> selectById() {
        try {
            //驼峰命名法
            GenerousBeanProcessor Processor = new GenerousBeanProcessor();
            BasicRowProcessor row = new BasicRowProcessor(Processor);
            return queryRunner.query("select create_time,indent_sn,commodity_name,commodity_number,commodity_img_url,receiver_name,receiver_phone,receiver_address,total_amount from indent "
                    ,new BeanListHandler<Indent>(Indent.class,row));
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
