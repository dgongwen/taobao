package cn.qf.taobao.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class DBUtil {
    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        InputStream resourceAsStream = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(resourceAsStream);
            dataSource= DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
