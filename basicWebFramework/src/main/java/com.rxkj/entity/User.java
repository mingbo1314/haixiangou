package com.rxkj.entity;

import com.rxkj.enumtype.ConfigEnum;
import com.rxkj.enumtype.UserStatusEnum;
import com.rxkj.utils.NativeConfigurationUtils;
import com.yeepay.g3.utils.persistence.Entity;

import java.math.BigDecimal;
import java.util.Date;

public class User implements Entity<Long> {

    private static final long serialVersionUID = -6702039650148227572L;
    /**
     * 编号
     */
    private Long id;

    /**
     * 登陆名称
     */
    private String loginName;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮件
     */
    private String email;

    /**
     * 密码输入错误次数
     */
    private Integer pwdErrorCounts;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后的登录时间
     */
    private Date lastLoginTime;

    /** 上次登录IP */
    private String lastLoginIP;

    /** 上次登录IP地理位置 */
    private String lastLoginIPLocation;

    /**
     * 使用状态
     */
    private UserStatusEnum status;

    /**
     * 交易密码
     */
    private String tradePassword;

    /**
     * 性别
     */
    private String sex;

    /**
     * 用户累计积分
     */
    private BigDecimal accumulateScore;

    /**
     * 默认地址id
     */
    private Long defaultIdAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPwdErrorCounts() {
        return pwdErrorCounts;
    }

    public void setPwdErrorCounts(Integer pwdErrorCounts) {
        this.pwdErrorCounts = pwdErrorCounts;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }

    public String getLastLoginIP() {
        return lastLoginIP;
    }

    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    public String getLastLoginIPLocation() {
        return lastLoginIPLocation;
    }

    public void setLastLoginIPLocation(String lastLoginIPLocation) {
        this.lastLoginIPLocation = lastLoginIPLocation;
    }


    public String getTradePassword() {
        return tradePassword;
    }

    public void setTradePassword(String tradePassword) {
        this.tradePassword = tradePassword;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public BigDecimal getAccumulateScore() {
        return accumulateScore;
    }

    public void setAccumulateScore(BigDecimal accumulateScore) {
        this.accumulateScore = accumulateScore;
    }

    public Long getDefaultIdAddress() {
        return defaultIdAddress;
    }

    public void setDefaultIdAddress(Long defaultIdAddress) {
        this.defaultIdAddress = defaultIdAddress;
    }

    /**
     * 获取剩余登录次数
     * @return
     */
    public int getRemainingLoginTimes() {
        if (this.pwdErrorCounts != null) {
            Long time = NativeConfigurationUtils.getSysConfigParam(ConfigEnum.MAXIMUM_PWD_ERROR_TIME);
            return time.intValue() - this.pwdErrorCounts;
        }
        return 0;
    }
}
