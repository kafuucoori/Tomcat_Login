package top.kafuucoori.entity;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/16 - 07 - 16 - 9:40
 * @Description: top.kafuucoori.entity
 * @version: 1.0
 * @param: cid
 * @param: country
 * 功能描述: entity，存放与数据库的Country表一一对应的java类
 */
public class Country {

    private int cid;
    private String country;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Country{" +
                "cid=" + cid +
                ", country='" + country + '\'' +
                '}';
    }

    public Country() {
    }

    public Country(int cid, String country) {
        this.cid = cid;
        this.country = country;
    }
}
