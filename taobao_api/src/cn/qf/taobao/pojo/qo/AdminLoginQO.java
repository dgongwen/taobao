package cn.qf.taobao.pojo.qo;

/**
 * 管理员登入实体类
 */
public class AdminLoginQO {
    private Long adminUserId; //管理员ID
    private String adminUserName;  //管理员用户名
    private String adminUserPassword;  //管理员账号密码

    public AdminLoginQO(Long adminUserId, String adminUserName, String adminUserPassword) {
        this.adminUserId = adminUserId;
        this.adminUserName = adminUserName;
        this.adminUserPassword = adminUserPassword;
    }

    public AdminLoginQO() {
    }

    public AdminLoginQO(String adminUserName, String adminUserPassword) {
        this.adminUserName = adminUserName;
        this.adminUserPassword = adminUserPassword;
    }

    public Long getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Long adminUserId) {
        this.adminUserId = adminUserId;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getAdminUserPassword() {
        return adminUserPassword;
    }

    public void setAdminUserPassword(String adminUserPassword) {
        this.adminUserPassword = adminUserPassword;
    }

    @Override
    public String toString() {
        return "AdminLoginQO{" +
                "adminUserId=" + adminUserId +
                ", adminUserName='" + adminUserName + '\'' +
                ", adminUserPassword='" + adminUserPassword + '\'' +
                '}';
    }
}
