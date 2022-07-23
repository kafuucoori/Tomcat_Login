package top.kafuucoori.dao.impl;

import top.kafuucoori.dao.CountryDao;
import top.kafuucoori.util.BaseDao;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/16 - 07 - 16 - 9:50
 * @Description: top.kafuucoori.dao.impl
 * @version: 1.0
 * 功能描述: dao，定义对country表的各种操作
 */
public class CountryDaoImpl extends BaseDao implements CountryDao {

    /**
     * 功能描述: 删除对应country
     *
     * @param: cid countryid
     * @return: int
     */
    @Override
    public int delCountryById(int cid) {

        String sql = "delete from country where cid = ?";
        int result = this.modifyData(sql, new Object[]{cid});

        return result;
    }

}
