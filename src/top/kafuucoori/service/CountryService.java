package top.kafuucoori.service;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/16 - 07 - 16 - 9:57
 * @Description: top.kafuucoori.service
 * @version: 1.0
 * 功能描述: service，实现对country的各种操作
 */
public interface CountryService {

    /**
     * 功能描述: 这个接口负责调用Dao层来删除对应country
     *
     * @param: cid countryid
     * @return: boolean
     */
    public boolean delCountryById(int cid);

}
