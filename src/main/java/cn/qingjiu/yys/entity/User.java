package cn.qingjiu.yys.entity;

public class User {
    private Integer userId;

    private Integer userNo;

    private String userName;

    private Integer sex;

    private Integer service;

    private String email;

    private String telephone;

    private String haveSp;

    private String likeSp;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getService() {
        return service;
    }

    public void setService(Integer service) {
        this.service = service;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getHaveSp() {
        return haveSp;
    }

    public void setHaveSp(String haveSp) {
        this.haveSp = haveSp == null ? null : haveSp.trim();
    }

    public String getLikeSp() {
        return likeSp;
    }

    public void setLikeSp(String likeSp) {
        this.likeSp = likeSp == null ? null : likeSp.trim();
    }
}