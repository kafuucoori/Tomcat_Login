package top.kafuucoori.test;

import top.kafuucoori.service.impl.CountryServiceImpl;
import top.kafuucoori.util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/15 - 07 - 15 - 11:53
 * @Description: top.kafuucoori.test
 * @version: 1.0
 * 功能描述: 测试类，测试数据库增删查改功能
 */
public class SqlOperateTest {

    @Test
    public void deletTest() {
        // 删除操作
        String sql = "delete from user where id = ?";
        Object[] obj = {1};
        BaseDao bd = new BaseDao();
        int result = bd.modifyData(sql, obj);
        if (result > 0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    @Test
    public void modifyTest() {
        // 修改操作
        String sql = "udpate user set name = ? where id = ?";
        Object[] obj = {"coori", 1};
        BaseDao bd = new BaseDao();
        int result = bd.modifyData(sql, obj);
        if (result > 0) {
            System.out.println("修改成功！");
        } else {
            System.out.println("修改失败！");
        }
    }

    @Test
    public void inquireTest() {
        // 查询操作
        String sql = "select * from user";
        Object[] obj = {};
        BaseDao bd = new BaseDao();
        ResultSet rs = bd.getDataByAny(sql, obj);
        try {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "---"
                        + rs.getString(2) + "---"
                        + rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delCountryTest() {
        // 删除国家操作
        CountryServiceImpl cs = new CountryServiceImpl();
        cs.delCountryById(4);
    }

}
