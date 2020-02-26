package club.csiqu.framework.mybatis.demo.entity;

/**
 * @author chensiqu [540498860@qq.com]
 * @since 2019/7/16 17:47
 */
public class User {

    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}