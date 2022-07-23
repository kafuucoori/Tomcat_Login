package top.kafuucoori.service;

import top.kafuucoori.entity.User;

import java.util.List;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/15 - 07 - 15 - 10:39
 * @Description: top.kafuucoori.service
 * @version: 1.0
 * 功能描述: service，实现用户的各种操作
 */
public interface UserService {

    /**
     * 功能描述: 这个接口负责调用Dao层来实现用户登录的方法
     *
     * @param: name  用户名
     * @param: pwd   密码
     * @return: boolean
     */
    public boolean login(String name, String pwd);

    /**
     * 功能描述: 这个接口负责调用Dao层实现返回用户是否注册成功的信息
     *
     * @param: user
     * @return: int
     */
    public int register(User user);

    /**
     * 功能描述: 这个接口负责调用Dao层返回所有User信息
     *
     * @return: List<User>
     */
    public List<User> getAllUser();

    /**
     * 功能描述: 这个接口负责调用Dao层根据id删除一个user对象
     *
     * @param: id user id
     * @return: int
     */
    public int delUserById(int id);

    /**
     * 功能描述: 这个接口负责调用Dao层根据id获取一个user对象
     *
     * @param: id user id
     * @return: user
     */
    public User getUserById(int id);

    /**
     * 功能描述: 这个接口负责调用Dao层根据id修改相应user对象
     *
     * @param: user user对象
     * @return: int
     */
    public int updateUserById(User user);

    /**
     * 功能描述: 这个接口负责调用Dao层根据获得的cid得到对应国家
     *
     * @return: List<User>
     */
    public List<User> getUserCountry();

    /**
     * 功能描述: 这个接口负责调用Dao层分页显示数据
     *
     * @param: int pageNo 页面编号
     * @param: int pageSize 页面容量
     * @return: List<User>
     */
    public List<User> getUserByPage(int pageNo, int pageSize);

    /**
     * 功能描述: 这个接口负责调用Dao层实现统计数据总条数
     *
     * @return: int
     */
    public int getUserCount();

    /**
     * 功能描述: 这个接口负责调用Dao层实现按页模糊查询
     *
     * @param: int pageNo 页面编号
     * @param: int pageSize 页面容量
     * @param: StringBuffer condition 筛选条件
     * @return: List<User>
     */
    public List<User> getUserByPageAndFuzzy(int pageNo, int pageSize ,StringBuffer condition);

    /**
     * 功能描述: 这个接口负责调用Dao层根据名称查找用户
     *
     * @param: User user
     * @return: boolean
     */
    public boolean getUserByName(User user);

}
