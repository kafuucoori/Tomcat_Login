package top.kafuucoori.service.impl;

import top.kafuucoori.dao.CountryDao;
import top.kafuucoori.dao.UserDao;
import top.kafuucoori.dao.impl.CountryDaoImpl;
import top.kafuucoori.dao.impl.UserDaoImpl;
import top.kafuucoori.service.CountryService;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/16 - 07 - 16 - 10:00
 * @Description: top.kafuucoori.service.impl
 * @version: 1.0
 * 功能描述: service，实现对country的各种操作
 */
public class CountryServiceImpl implements CountryService {

    CountryDao cd = new CountryDaoImpl();
    UserDao ud = new UserDaoImpl();

    /**
     * 功能描述: 调用Dao层来实现删除country的方法
     *
     * @param: cid countryid
     * @return: boolean 是否删除成功
     */
    @Override
    public boolean delCountryById(int cid) {

        if (ud.getUserCountByCid(cid) == 0) {
            cd.delCountryById(cid);
            System.out.println("删除成功");
            return true;
        } else {
            System.out.println("当前country还有内容，无法进行删除");
            return false;
        }

    }

}
