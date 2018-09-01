package com.lihoo.ssm.model;

public class StudentInfo {
    private Long id;

    private String username;

    private String pwd;

    private Long createAt;

    private Long expireAt;

    private Long qq;

    private String email;

    private String address;

    private Long phone;

    private Integer status;

    public StudentInfo() {
    }

    public StudentInfo(Long id, String username, String pwd, Long createAt, Long expireAt, Long qq, String email, String address, Long phone, Integer status) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
        this.createAt = createAt;
        this.expireAt = expireAt;
        this.qq = qq;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Long expireAt) {
        this.expireAt = expireAt;
    }

    public Long getQq() {
        return qq;
    }

    public void setQq(Long qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", createAt=" + createAt +
                ", expireAt=" + expireAt +
                ", qq=" + qq +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", status=" + status +
                '}';
    }
}