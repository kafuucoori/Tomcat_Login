package top.kafuucoori.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/15 - 07 - 15 - 11:03
 * @Description: top.kafuucoori.util
 * @version: 1.0
 * 功能描述: 工具类，实现数据库的各种操作
 */
public class BaseDao {

    /**
     * 功能描述: 实现数据库修改功能
     *
     * @param: sql  数据库操作语句
     * @param: obj  数据库操作参数
     * @return: int 数据库操作影响行数
     */
    public int modifyData(String sql, Object[] obj) {

        Connection conn = ConnUtil.getConn();
        PreparedStatement pstmt = null;
        int result = 0;

        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                pstmt.setObject(i + 1, obj[i]);
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;

    }

    /**
     * 功能描述: 实现数据库查询功能
     *
     * @param: sql  数据库操作语句
     * @param: obj  数据库操作参数
     * @return: ResultSet   数据库查询结果
     */
    public ResultSet getDataByAny(String sql, Object[] obj) {

        Connection conn = ConnUtil.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                pstmt.setObject(i + 1, obj[i]);
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;

    }

}
