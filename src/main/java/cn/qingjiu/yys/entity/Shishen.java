package cn.qingjiu.yys.entity;

public class Shishen {
    private Integer id;

    private String shishenName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShishenName() {
        return shishenName;
    }

    public void setShishenName(String shishenName) {
        this.shishenName = shishenName == null ? null : shishenName.trim();
    }
}