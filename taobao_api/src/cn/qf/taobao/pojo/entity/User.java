package cn.qf.taobao.pojo.entity;

import java.math.BigDecimal;

//用户信息表
public class User {

    private Long id;//id
    private String userName;//用户名
    private String password;//密码
    private String name;//姓名
    private String phone;//电话
    private String sex;//性别
    private String birthData;//出生日期
    private String imgUrl;//用户头像
    private double blance;//账户余额
    private String email;//用户邮箱
    private Long paymentPassword;//用户支付密码
    private String verification;//用户支付密码

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public double getBlance() {
        return blance;
    }

    public void setBlance(double blance) {
        this.blance = blance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", birthData='" + birthData + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", blance=" + blance +
                ", email='" + email + '\'' +
                ", paymentPassword=" + paymentPassword +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthData() {
        return birthData;
    }

    public void setBirthData(String birthData) {
        this.birthData = birthData;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPaymentPassword() {
        return paymentPassword;
    }

    public void setPaymentPassword(Long paymentPassword) {
        this.paymentPassword = paymentPassword;
    }
}
