package top.kafuucoori.dao;

import top.kafuucoori.entity.User;

import java.util.List;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/15 - 07 - 15 - 10:35
 * @Description: top.kafuucoori.dao
 * @version: 1.0
 * 功能描述: dao，定义对用户表的各种操作
 */
public interface UserDao {

    /**
     * 功能描述: 这个接口负责用户登录操作
     *
     * @param: name  用户名
     * @param: pwd   密码
     * @return: boolean 是否登录成功
     */
    public boolean login(String name, String pwd);

    /**
     * 功能描述: 这个接口负责用户注册操作
     *
     * @param: user
     * @return: int
     */
    public int register(User user);

    /**
     * 功能描述: 这个接口负责统计country人数
     *
     * @param: cid countryid
     * @return: int
     */
    public int getUserCountByCid(int cid);

    /**
     * 功能描述: 这个接口负责返回所有User信息
     *
     * @return: List<User>
     */
    public List<User> getAllUser();

    /**
     * 功能描述: 这个接口根据id删除一个user对象
     *
     * @param: id user id
     * @return: int
     */
    public int delUserById(int id);

    /**
     * 功能描述: 这个接口根据id获取一个user对象
     *
     * @param: id user id
     * @return: user
     */
    public User getUserById(int id);

    /**
     * 功能描述: 这个接口根据id修改相应user对象
     *
     * @param: user user对象
     * @return: int
     */
    public int updateUserById(User user);

    /**
     * 功能描述: 这个接口根据获得的cid得到对应国家
     *
     * @return: List<User>
     */
    public List<User> getUserCountry();

    /**
     * 功能描述: 这个接口实现分页显示数据（减轻服务器压力并增加用户体验）
     *
     * @param: int pageNo 页面编号
     * @param: int pageSize 页面容量
     * @return: List<User>
     */
    public List<User> getUserByPage(int pageNo, int pageSize);

    /**
     * 功能描述: 这个接口实现统计数据总条数
     *
     * @return: int
     */
    public int getUserCount();

    /**
     * 功能描述: 这个接口实现按页模糊查询
     *
     * @param: int pageNo 页面编号
     * @param: int pageSize 页面容量
     * @param: StringBuffer condition 筛选条件
     * @return: List<User>
     */
    public List<User> getUserByPageAndFuzzy(int pageNo, int pageSize ,StringBuffer condition);

    /**
     * 功能描述: 这个接口实现根据名称查找用户
     *
     * @param: User user
     * @return: boolean
     */
    public boolean getUserByName(User user);

}
