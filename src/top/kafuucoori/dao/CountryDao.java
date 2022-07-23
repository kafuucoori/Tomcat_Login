package top.kafuucoori.dao;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/16 - 07 - 16 - 9:45
 * @Description: top.kafuucoori.dao
 * @version: 1.0
 * 功能描述: dao，定义对country表的各种操作
 */
public interface CountryDao {

    /**
     * 功能描述: 这个接口负责删除对应country
     *
     * @param: cid countryid
     * @return: int
     */
    public int delCountryById(int cid);

}
