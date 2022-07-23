package top.kafuucoori.entity;

/**
 * @Author: KafuuCoori
 * @Date: 2022/7/15 - 07 - 15 - 10:32
 * @Description: top.kafuucoori.entity
 * @version: 1.0
 * @param: id
 * @param: name
 * @param: pwd
 * @param: hobby
 * @param: cid
 * 功能描述: entity，存放与数据库的User表一一对应的java类
 */
public class User {

    private int id;
    private String name;
    private String pwd;
    private String hobby;
    private int cid;
    private Country country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", hobby='" + hobby + '\'' +
                ", cid=" + cid +
                '}';
    }

    public User() {
    }

    public User(String name, String pwd, String hobby, int cid) {
        this.name = name;
        this.pwd = pwd;
        this.hobby = hobby;
        this.cid = cid;
    }

    public User(int id, String name, String pwd, String hobby, int cid) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.hobby = hobby;
        this.cid = cid;
    }
}
