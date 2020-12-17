package cn.qf.taobao.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * DBUtil连接池
 */
public class DruidUtil {
        private static DataSource dataSource;
        static {
                Properties properties = new Properties();
                InputStream resourceAsStream = DruidUtil.class.getClassLoader().getResourceAsStream("db.properties");
                try {
                        properties.load(resourceAsStream);
                        dataSource =  DruidDataSourceFactory.createDataSource(properties);
                } catch (IOException e) {
                        e.printStackTrace();
                } catch (Exception e) {
                        e.printStackTrace();
                }

        }

        public static DataSource getDataSource() {
                return dataSource;
        }
}
