package top.kafuucoori.service.impl;

import top.kafuucoori.dao.UserDao;
import top.kafuucoori.dao.impl.UserDaoImpl;
import top.kafuucoori.entity.User;
import top.kafuucoori.service.UserService;

import java.util.List;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/15 - 07 - 15 - 10:41
 * @Description: top.kafuucoori.service.impl
 * @version: 1.0
 * 功能描述: service，实现用户的各种操作
 */
public class UserServiceImpl implements UserService {

    private UserDao ud = new UserDaoImpl();

    /**
     * 功能描述: 调用Dao层来实现用户登录方法
     *
     * @param: name  用户名
     * @param: pwd   密码
     * @return: boolean
     */
    @Override
    public boolean login(String name, String pwd) {
        return ud.login(name, pwd);
    }

    /**
     * 功能描述: 调用Dao层实现返回用户是否注册成功的信息
     *
     * @param: user
     * @return: int
     */
    public int register(User user) {
        return ud.register(user);
    }

    /**
     * 功能描述: 调用Dao层返回所有User信息的方法
     *
     * @return: List<User>
     */
    @Override
    public List<User> getAllUser() {
        return ud.getAllUser();
    }

    /**
     * 功能描述: 调用Dao层根据id删除一个user对象
     *
     * @param: id user id
     * @return: int
     */
    @Override
    public int delUserById(int id) {
        return ud.delUserById(id);
    }

    /**
     * 功能描述: 调用Dao层根据id获取一个user对象
     *
     * @param: id user id
     * @return: user
     */
    public User getUserById(int id) {
        return ud.getUserById(id);
    }

    /**
     * 功能描述: Dao层根据id修改相应user对象
     *
     * @param: user user对象
     * @return: int
     */
    public int updateUserById(User user) {
        return ud.updateUserById(user);
    }

    /**
     * 功能描述: 调用Dao层根据获得的cid得到对应国家
     *
     * @return: List<User>
     */
    public List<User> getUserCountry() {
        return ud.getUserCountry();
    }

    /**
     * 功能描述: 调用Dao层分页显示数据
     *
     * @param: int pageNo 页面编号
     * @param: int pageSize 页面容量
     * @return: List<User>
     */
    public List<User> getUserByPage(int pageNo, int pageSize) {
        return ud.getUserByPage(pageNo, pageSize);
    }

    /**
     * 功能描述: 调用Dao层实现统计数据总条数
     *
     * @return: int
     */
    public int getUserCount() {
        return ud.getUserCount();
    }

    /**
     * 功能描述: 调用Dao层实现按页模糊查询
     *
     * @param: int pageNo 页面编号
     * @param: int pageSize 页面容量
     * @param: StringBuffer condition 筛选条件
     * @return: List<User>
     */
    public List<User> getUserByPageAndFuzzy(int pageNo, int pageSize ,StringBuffer condition){
        return ud.getUserByPageAndFuzzy(pageNo, pageSize, condition);
    }

    /**
     * 功能描述: 调用Dao层根据名称查找用户
     *
     * @param: User user
     * @return: boolean
     */
    public boolean getUserByName(User user){
        return ud.getUserByName(user);
    }

}
