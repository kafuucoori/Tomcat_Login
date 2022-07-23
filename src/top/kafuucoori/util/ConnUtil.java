package top.kafuucoori.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/15 - 07 - 15 - 10:57
 * @Description: top.kafuucoori.util
 * @version: 1.0
 * 功能描述: 工具类，与数据库建立连接
 */
public class ConnUtil {

    /**
     * 功能描述: 进行与数据库的连接
     *
     * @param: druidpath  配置文件目录
     * @return: Connection 连接参数
     */
    public static Connection getConn() {

        String druidpath = "F:\\_Study\\_Project\\Tomcat_Login\\druid.properties";
        Connection conn = null;

        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(druidpath));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;

    }

}
