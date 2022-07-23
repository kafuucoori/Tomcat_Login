package top.kafuucoori.dao.impl;

import top.kafuucoori.dao.UserDao;
import top.kafuucoori.entity.Country;
import top.kafuucoori.entity.User;
import top.kafuucoori.util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/15 - 07 - 15 - 10:37
 * @Description: top.kafuucoori.dao.impl
 * @version: 1.0
 * 功能描述: dao，定义对用户表的各种操作
 */

public class UserDaoImpl extends BaseDao implements UserDao {

    /**
     * 功能描述: 返回用户是否登录成功的信息
     *
     * @param: name  用户名
     * @param: pwd   密码
     * @return: boolean
     */
    @Override
    public boolean login(String name, String pwd) {

        String sql = "select * from user where name = ? and pwd = ?";
        Object[] obj = {name, pwd};
        ResultSet rs = this.getDataByAny(sql, obj);
        boolean flag = false;

        try {
            while (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;

    }

    /**
     * 功能描述: 返回用户是否注册成功的信息
     *
     * @param: user
     * @return: int
     */
    @Override
    public int register(User user) {

        String sql = "insert into user (name, pwd, hobby, cid) values (?, ?, ?, ?)";
        return this.modifyData(sql, new Object[]{user.getName(), user.getPwd(), user.getHobby(), user.getCid()});

    }

    /**
     * 功能描述: 统计country人数
     *
     * @param: cid countryid
     * @return: int
     */
    @Override
    public int getUserCountByCid(int cid) {

        String sql = "Select count(1) from user where cid = ?";
        ResultSet rs = this.getDataByAny(sql, new Object[]{cid});
        int count = 0;

        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;

    }

    /**
     * 功能描述: 返回所有User信息
     *
     * @return: List<User>
     */
    @Override
    public List<User> getAllUser() {

        String sql = "select * from user";
        ResultSet rs = this.getDataByAny(sql, new Object[]{});
        ArrayList<User> list = new ArrayList<>();

        try {
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPwd(rs.getString(3));
                u.setHobby(rs.getString(4));
                u.setCid(rs.getInt(5));
                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 功能描述: 根据id删除一个user对象
     *
     * @param: id user id
     * @return: int
     */
    @Override
    public int delUserById(int id) {

        String sql = "delete from user where id = ?";
        return this.modifyData(sql, new Object[]{id});

    }

    /**
     * 功能描述: 根据id获取一个user对象
     *
     * @param: id user id
     * @return: user
     */
    public User getUserById(int id) {

        String sql = "select * from user where id = ?";
        ResultSet rs = this.getDataByAny(sql, new Object[]{id});
        User u = new User();

        try {
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPwd(rs.getString(3));
                u.setHobby(rs.getString(4));
                u.setCid(rs.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;

    }

    /**
     * 功能描述: 根据id修改相应user对象
     *
     * @param: user user对象
     * @return: int
     */
    public int updateUserById(User user) {

        String sql = "update user set name = ?, hobby = ?, cid = ? where id = ?";
        Object[] obj = new Object[]{user.getName(), user.getHobby(), user.getCid(), user.getId()};
        return this.modifyData(sql, obj);

    }

    /**
     * 功能描述: 根据获得的cid得到对应国家
     *
     * @return: List<User>
     */
    public List<User> getUserCountry() {

        String sql = "select id, name, pwd, hobby, country from user, country where user.cid = country.cid";
        ResultSet rs = this.getDataByAny(sql, new Object[]{});
        List<User> list = new ArrayList<>();

        try {
            while (rs.next()) {
                User u = new User();
                Country c = new Country();

                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPwd(rs.getString(3));
                u.setHobby(rs.getString(4));
                c.setCountry(rs.getString(5));
                u.setCountry(c);

                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

    /**
     * 功能描述: 分页显示数据（减轻服务器压力并增加用户体验）
     *
     * @param: int pageNo 页面编号
     * @param: int pageSize 页面容量
     * @return: List<User>
     */
    public List<User> getUserByPage(int pageNo, int pageSize) {

        String sql = "select * from user, country where user.cid = country.cid limit ?, ?";
        ResultSet rs = this.getDataByAny(sql, new Object[]{(pageNo - 1) * pageSize, pageSize});
        List<User> list = new ArrayList<>();

        try {
            while (rs.next()) {
                User u = new User();
                Country c = new Country();

                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPwd(rs.getString(3));
                u.setHobby(rs.getString(4));
                c.setCountry(rs.getString(5));
                u.setCountry(c);

                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

    /**
     * 功能描述: 实现统计数据总条数
     *
     * @return: int
     */
    public int getUserCount() {

        String sql = "select count(1) from user";
        ResultSet rs = this.getDataByAny(sql, new Object[]{});
        int count = 0;

        try {
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;

    }

    /**
     * 功能描述: 实现按页模糊查询
     *
     * @param: int pageNo 页面编号
     * @param: int pageSize 页面容量
     * @param: StringBuffer condition 筛选条件
     * @return: List<User>
     */
    public List<User> getUserByPageAndFuzzy(int pageNo, int pageSize, StringBuffer condition) {

        String sql = "select id, name, pwd, hobby, country from user, country where user.cid = country.cid " + condition + " limit ?, ?";
        ResultSet rs = this.getDataByAny(sql, new Object[]{(pageNo - 1) * pageSize, pageSize});
        List<User> list = new ArrayList<>();

        try {
            while (rs.next()) {
                User u = new User();
                Country c = new Country();

                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPwd(rs.getString(3));
                u.setHobby(rs.getString(4));
                c.setCountry(rs.getString(5));
                u.setCountry(c);

                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

    /**
     * 功能描述: 根据名称查找用户
     *
     * @param: User user
     * @return: boolean
     */
    public boolean getUserByName(User user) {

        String sql = "select * from user where name = ?";
        ResultSet rs = this.getDataByAny(sql, new Object[]{user.getName()});
        boolean result = false;

        try {
            while(rs.next()){
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;

    }

}
